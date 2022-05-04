package com.thecodeveal.app.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import com.thecodeveal.app.entities.Vehicle;
import com.thecodeveal.app.repository.UserDetailsRepository;

import com.thecodeveal.app.repository.VehicleRepository;
import com.thecodeveal.app.repository.VehicleServiceRepo;
import com.thecodeveal.app.responses.VehicleInfo;
import com.thecodeveal.app.services.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.thecodeveal.app.config.JWTTokenHelper;
import com.thecodeveal.app.entities.User;
import com.thecodeveal.app.requests.AuthenticationRequest;
import com.thecodeveal.app.responses.LoginResponse;
import com.thecodeveal.app.responses.UserInfo;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenHelper jWTTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private CustomUserService customUserService;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	VehicleServiceRepo vehicleServiceRepo;

	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/auth/registration")
	public String registerUserAccount(@RequestBody UserInfo userInfo) {

		User user = new User(
				userInfo.getEmail(),
				userInfo.getFirstName(),
				userInfo.getLastName(),
				encoder.encode(userInfo.getPassword()),
				userInfo.getPhoneNumber(),
				userInfo.getUserName())
				;
		userDetailsRepository.save(user);
		return "redirect:/registration?success";
	}

	@PostMapping("/auth/addVehicle")
	public String addVehicle(@RequestBody VehicleInfo vehicleInfo) {
		Vehicle vehicle = new Vehicle(
				vehicleInfo.getEmail(),
				vehicleInfo.getType(),
				vehicleInfo.getVehicleNum()
		);
		vehicleRepository.save(vehicle);
		return "redirect:/addVehicle?success";
	}
//success
	@RequestMapping ("/auth/editVehicle/{id}")
	public String editVehicle(@RequestBody VehicleInfo vehicleInfo, @PathVariable String email) {
		Vehicle exvehicle = vehicleRepository.getVehicleByEmail(email);
//				exvehicle.setOwnerId(exvehicle.getOwnerId());
				exvehicle.setType(vehicleInfo.getType());
				exvehicle.setVehicleNum(vehicleInfo.getVehicleNum());
		//vehicleRepository.save(exvehicle);
		vehicleServiceRepo.updateVehicle(exvehicle);
		return "redirect:/editVehicle?success";
	}

//	@RequestMapping ("/auth/editUser/{id}")
//	public String editUser(@RequestBody UserInfo userInfo, @PathVariable Long id) {
//		User ex = userDetailsRepository.getById(id);
//		ex.setFirstName(userInfo.getFirstName());
//		ex.setLastName(userInfo.getLastName());
//		ex.setPhoneNumber(userInfo.getPhoneNumber());
//		ex.setPassword(userInfo.getPassword());
//		userDetailsRepository.updateUser(ex);
//		return "redirect:/editUser?success";
//	}


	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

		try {
			final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));

			String jwtToken=jWTTokenHelper.generateToken(authenticationRequest.getUserName());

			LoginResponse response=new LoginResponse();
			response.setToken(jwtToken);

			return ResponseEntity.ok(response);

		}

		catch (Exception e) {
			return new ResponseEntity<>("Login Failed",
					HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/auth/vehicles")
	public List<Vehicle> listVehicles(Model model) {
		model.addAttribute("vehicles", vehicleServiceRepo.getAllVehicles());
		return vehicleRepository.findAll();
	}

}

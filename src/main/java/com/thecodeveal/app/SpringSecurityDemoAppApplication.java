package com.thecodeveal.app;

import com.thecodeveal.app.repository.UserDetailsRepository;
import com.thecodeveal.app.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@CrossOrigin
public class SpringSecurityDemoAppApplication {

//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private UserDetailsRepository userDetailsRepository;
//
//	@Autowired
//	private VehicleRepository vehicleRepository;


//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//				.allowedMethods("*");
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoAppApplication.class, args);
	}
}

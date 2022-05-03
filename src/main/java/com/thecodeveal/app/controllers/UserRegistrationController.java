//package com.thecodeveal.app.controllers;
//
//import com.thecodeveal.app.entities.User;
//import com.thecodeveal.app.repository.UserDetailsRepository;
//import com.thecodeveal.app.responses.UserInfo;
//import com.thecodeveal.app.services.CustomUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResultUtils;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/registration")
//public class UserRegistrationController {
//
//    @Autowired
//    private CustomUserService customUserService;
//
//    @Autowired
//    UserDetailsRepository userDetailsRepository;
//
//    @ModelAttribute("user")
//    public UserInfo userInfo() {
//        return new UserInfo();
//    }
//
//    @GetMapping
//    public String showRegistration(Model model) {
//        return "registration";
//    }
//
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user") @Validated UserInfo userInfo, BindingResultUtils result) {
//        User existing = (User) customUserService.loadUserByUsername(userInfo.getUserName());
//        if (existing != null) {
//            result.toString();
//        }
//
//        User user = new User(
//                userInfo.getFirstName(),
//                userInfo.getLastName(),
//                userInfo.getEmail(),
//                userInfo.getPassword(),
//                userInfo.getUserName(),
//                userInfo.getPhoneNumber())
//                ;
//        userDetailsRepository.save(user);
//
//        return "redirect:/registration?success";
//    }
//}

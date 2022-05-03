package com.thecodeveal.app.services;

import com.thecodeveal.app.entities.User;
import com.thecodeveal.app.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//
//		User user=userDetailsRepository.findByUserName(username);
//
//		if(null==user) {
//			throw new UsernameNotFoundException("User Not Found with userName "+username);
//		}
//		return this.build(user);

		User user = userDetailsRepository.findByUserName(username);
		if(user == null)throw new UsernameNotFoundException("Not found: " + username);
		System.out.println(user.getUserName());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());

	}


//	public UserDetailImpl build(User userInfo) {
//		UserDetailImpl user = new UserDetailImpl(
//				userInfo.getId(),
//				userInfo.getEmail(),
//				userInfo.getFirstName(),
//				userInfo.getLastName(),
//				userInfo.getPassword(),
//				userInfo.getPhoneNumber(),
//				userInfo.getUserName()) {
//		}
				;
//		return user;
//	}
}

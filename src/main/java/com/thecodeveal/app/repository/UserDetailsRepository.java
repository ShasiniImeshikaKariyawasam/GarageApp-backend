package com.thecodeveal.app.repository;

import com.thecodeveal.app.responses.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thecodeveal.app.entities.User;


@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);
	User save(UserInfo registration);

//	User updateUser(User user);

}



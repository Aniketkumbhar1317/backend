package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	    User findByUserName(String userName);

		User findByUserNameAndPassword(String userName, String password);
		
		User findByAdmin(Boolean role);
}

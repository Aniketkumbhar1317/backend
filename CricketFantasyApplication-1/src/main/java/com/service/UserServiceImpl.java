package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	
	public User registerUser(User user) {

		// Check if username is already taken
		if (repo.findByUserName(user.getUserName()) != null) {
			throw new RuntimeException("Username already exists");
		}

		// Save the user to the database
		return repo.save(user);
	}

	
	 public User loginUser(String userName, String password) { 
		
		 User user = repo.findByUserNameAndPassword(userName, password);
		 
	 if (user == null) {
		 
		 throw new RuntimeException("Invalid userName or password"); 
		 }
	 
	 return user; 
	 }


	@Override
	public User findAdmin(Boolean role) {
		// TODO Auto-generated method stub
		return repo.findByAdmin(role);
	}
	 
}

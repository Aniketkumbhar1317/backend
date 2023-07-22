package com.service;

import com.model.User;

public interface UserService {

	 public User registerUser(User user);
	
	 public User loginUser(String userName, String password);
	 
	 public User findAdmin(Boolean role);
}

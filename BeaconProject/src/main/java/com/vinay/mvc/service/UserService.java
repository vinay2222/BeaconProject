package com.vinay.mvc.service;

import java.util.List;

import com.vinay.mvc.model.User;



public interface UserService {
	public void addUser(User user);
	public List<User> listusers();
	public User findById(int userid);
	public void updateUser(User currentUser);
	
	/*public boolean isUserExist(User user);*/
	
}

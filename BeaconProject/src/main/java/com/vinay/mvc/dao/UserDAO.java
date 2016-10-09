package com.vinay.mvc.dao;

import java.util.List;

import com.vinay.mvc.model.User;



public interface UserDAO {
	public void addUser(User user);
	public List<User> listusers();
	User findById(int userId);
	public void updateUser(User user);
	

}

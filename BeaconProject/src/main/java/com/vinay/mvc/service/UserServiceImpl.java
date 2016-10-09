package com.vinay.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinay.mvc.dao.UserDAO;
import com.vinay.mvc.model.User;



@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userdao;
	
	private static List<User> users;
	 public List<User> findAllUsers() {
	        return users;
	    }
	
	public void addUser(User user) {
		userdao.addUser(user);
		
	}
	public List<User> listusers(){
		return userdao.listusers();
	}
	/* public boolean isUserExist(User user) {
	        return findByName(user.getLastname())!=null;
	    }
	 private static List<User> users;
	private User findByName(String lastname) {
		for(User user : users){
            if(user.getLastname().equalsIgnoreCase(lastname)){
                return user;
            }
        }
        return null;
	}*/
	@Override
	public User findById(int userid) {
		return userdao.findById(userid);
	}

	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
		
		
	}

}

package com.vinay.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vinay.mvc.model.User;
import com.vinay.mvc.service.Mail;
import com.vinay.mvc.service.UserService;




@RestController
//@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userservice;
	@Autowired
	private Mail mail;
	
	@CrossOrigin
	 @RequestMapping(value = "/user/add", method = RequestMethod.POST , produces = "application/json")
	    public ResponseEntity<Void> createUser(@RequestBody User user) {
	       // System.out.println("Creating User " + user.getLastname());
	 
	       /* if (userservice.isUserExist(user)) {
	            System.out.println("A User with name " + user.getLastname() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }*/
		 try{ userservice.addUser(user);
         mail.sendEmail(user);}
		 catch(Exception e){e.printStackTrace();}
	       
	        
	        	 return new ResponseEntity<Void>(HttpStatus.CREATED);
	        
	      //  HttpHeaders headers = new HttpHeaders();
	        //headers.setLocation(ucBuilder.path("/user/{userid}").buildAndExpand(user.getUserid()).toUri());
	       
	    }
	@CrossOrigin
	 @RequestMapping(value = "/user/patients", method = RequestMethod.GET)
	    public ResponseEntity<List<User>> listusers() {
	        List<User> users = userservice.listusers();
	       /* if(users.isEmpty()){
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }*/
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	    }
	
	@CrossOrigin
	 @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	    public ResponseEntity<User> getUser(@PathVariable("userid") int userid) {
	        User user = userservice.findById(userid);
	       /* if(users.isEmpty()){
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }*/
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    }
	
	 @RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
	    public ResponseEntity<User> updateUser(@PathVariable("userid") int userid, @RequestBody User user) {
	        System.out.println("Updating User " + userid);
	         
	        User currentUser = userservice.findById(userid);
	         
	        if (currentUser==null) {
	            System.out.println("User with id " + userid + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setFirstname(user.getFirstname());
	        currentUser.setLastname(user.getLastname());
	        currentUser.setMobileno(user.getMobileno());
	        currentUser.setEmailid(user.getEmailid());
	        userservice.updateUser(currentUser);
	        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	    }
	 
	 
	 
	 
	
}

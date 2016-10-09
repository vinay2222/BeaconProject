package com.vinay.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vinay.mvc.model.User;

@Service("Mail")
@Transactional
public class MailImpl implements Mail {

	@Autowired
    public MailSender mailSender;  
	@Override
	public void sendEmail(User user) {
		String firstname = user.getFirstname();
		   
        SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom("vinaycogent.gmail.com");
        message.setTo("vinay2222@gmail.com");
        message.setSubject("Test Email");
        message.setText("Hello There ! A new patient name "+firstname+" has joined");
        try{
        	mailSender.send(message);
        	 
        }catch(Exception e){
        	e.printStackTrace();
        	System.out.println("Not success");
        	
        }
		
	}

}

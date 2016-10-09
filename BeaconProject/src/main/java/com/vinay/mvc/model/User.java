package com.vinay.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	//public int id;
	
	
	 
	 
	@Column(name = "firstname")
	public String firstname;
	@Column(name = "lastname")
	public String lastname;
	@Column(name = "emailid")
	public String emailid;
	

	@Column(name = "mobileno")
	public int mobileno;
	@Id
	@GeneratedValue
	public int userid;
	
	/*public enum Gender {
	    MALE, FEMALE
	}
	@Column(name = "address")
	public String address;
	@Column(name = "city")
	public String city;
	@Column(name="state")
	public String state;
	@Column(name ="zipcode")
	public int zipcode;
	@Column(name = "gender")
	private Gender Gender;
	public Gender getGender() {
		return Gender;
	}
	public void setGender(Gender gender) {
		Gender = gender;
	} */
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public User(){
		
	}
	public User(String firstname, String lastname, String emailid, int mobileno, int userid		) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.userid = userid;
		
	}
	
	
}
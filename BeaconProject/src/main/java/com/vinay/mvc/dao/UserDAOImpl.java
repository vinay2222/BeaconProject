package com.vinay.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vinay.mvc.model.User;


@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
	     this.sessionFactory = sessionFactory;
	 }
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listusers() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from User").list();
	}
	
	 @Override
	  public User findById(int userid) {
	    return (User) sessionFactory.
	      getCurrentSession().
	      get(User.class, userid);
	  }
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		getCurrentSession().update(user);
        
	}
	

}

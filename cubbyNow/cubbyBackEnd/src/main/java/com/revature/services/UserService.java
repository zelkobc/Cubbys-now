package com.revature.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@Service
public class UserService {
	private final UserDAO uDao;
	
	@Autowired 
	UserService(UserDAO u) {
		uDao = u;	
	}
	public void addUser(User u) {
		User user = uDao.findUserByName(u.getName());
		if (user != null) { // catch an exception for this instead
			return;
		} else {
			uDao.save(u);
		}
	}
	public User getUser(int id) {
		System.out.println("get reached");
		User user = uDao.findById(id).get();
		if (user != null) {
			return user;
		} else {
			return null;
		}
    }
}	
	

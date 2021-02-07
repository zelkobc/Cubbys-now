package com.revature.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDAO;

@Service
public class UserService {
	private final UserDAO userDao;
	
	@Autowired 
	UserService(UserDAO u) {
		userDao = u;	
	}
	public Integer addUser(User u) {
//		User user = userDao.findUserByName(u.getUsername());
//		if (user != null) { // catch an exception for this instead
//			return -1;
//		} else {
			userDao.save(u);
//		}
		return u.getid();
	}
	public User getUser(int id) {
		System.out.println("get reached");
		User user = userDao.findById(id).get();
		if (user != null) {
			return user;
		} else {
			return null;
		}
    }
	
	public User getUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
	
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	public void updateUser(User u) {
		userDao.save(u);
	}
	
	public void deleteUser(User u) {
		userDao.delete(u);
	}
}	
	

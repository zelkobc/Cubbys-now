package com.revature.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.beans.Role;
import com.revature.data.RoleDAO;

@Service
public class RoleService {
	private final RoleDAO rDao;
	
	@Autowired
	RoleService(RoleDAO r) {
		rDao = r;
	}
	
	public Role getRole(int id) {
		Role role = rDao.findById(id).get();
		if (role != null) {
		 return role; 
		 }
		else { 
			return null;
		}
	}
}

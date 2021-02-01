package com.revature.services;

import java.util.List;
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
    
     // Create
	 public Integer addRole(Role role){
	     return rDao.save(role).getId();
	 }

     // Read
	 public Role getRole(Integer id){
	     return rDao.findById(id).get();
	 }

	 public List<Role> getAllRoles(){
	     return rDao.findAll();
	 }

	 // Update
     public void updateRole(Role role){
         rDao.save(role);
     }

     // Delete
     public void deleteRole(Integer id){
         Role role = rDao.findById(id).get();
         rDao.delete(role);
     }
}

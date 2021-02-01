package com.revature.controllers;

import java.util.List;

import com.revature.services.*;
import com.revature.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping(path ="/roles")
public class RoleController {
	
	private final RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	// Read
	@GetMapping(path="/{roleId}")
	public ResponseEntity<Role> getRoleById(@PathVariable int roleId) {
		Role r = this.roleService.getRole(roleId);
		if( r != null) {
			return ResponseEntity.ok(r);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Role>> getAllRoles(){
	    return ResponseEntity.ok(roleService.getAllRoles());
	}

	// Create
	@PostMapping
	public ResponseEntity<Integer> addRole(@RequestBody Role role){
	    System.out.println(role);
        Role check = null; 
	    try{
	        check = roleService.getRole(role.getId());
	        System.out.println(check);
	    }
	    catch(Exception e){
	    }
	    if(check == null){
	        return ResponseEntity.ok(roleService.addRole(role));
	    } 
	    else{
	        return ResponseEntity.badRequest().build();
	    }
	}

	// Update
	@PutMapping
	public ResponseEntity<Void> updateRole(@RequestBody Role role){
	    Role check = null; 
	    try{
	        check = roleService.getRole(role.getId());
	        System.out.println(check);
	    }
	    catch(Exception e){
	        check = null;
	    }
	    if(check != null){
	        roleService.updateRole(role);
	        return ResponseEntity.ok().build();
	    } 
	    else{
	        return ResponseEntity.notFound().build();
	    }
	}

	// Delete
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> deleteRole(@PathVariable Integer id){
	    roleService.deleteRole(id);
	    return ResponseEntity.ok().build();
	}
}

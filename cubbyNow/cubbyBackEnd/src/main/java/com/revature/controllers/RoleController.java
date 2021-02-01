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
@RequestMapping(path ="/role")
public class RoleController {
	
	private final RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
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

	@PostMapping
	public ResponseEntity<Integer> addRole(@PathVariable Role role){
	    return ResponseEntity.ok(roleService.addRole(role));
	}

	@PutMapping
	public ResponseEntity<Void> updateRole(@PathVariable Role role){
	    roleService.updateRole(role);
	    return ResponseEntity.ok().build();
	}

	@DeleteMapping(path="/{roleId}")
	public ResponseEntity<Void> deleteRole(@PathVariable Integer id){
	    roleService.deleteRole(id);
	    return ResponseEntity.ok().build();
	}
}

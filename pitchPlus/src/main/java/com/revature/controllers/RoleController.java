package com.revature.controllers;

import com.revature.services.*;
import com.revature.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
}

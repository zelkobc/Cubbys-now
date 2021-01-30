package com.revature.controllers;

import com.revature.services.*;
import com.revature.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired 
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping(path ="/{userId}")
	public ResponseEntity<Users> getUserById(@PathVariable int userId){
	System.out.println(userId + "line!");
	Users u = this.userService.getUserById(userId);
	if(u != null) {
		return ResponseEntity.ok(u);
	} else {
		return ResponseEntity.notFound().build();
	}
	}
}

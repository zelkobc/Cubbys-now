package com.revature.controllers;

import com.revature.services.*;
import com.revature.beans.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping(path = "/users")
public class UserController {
	
	private final UserService userService;
	@Autowired 
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping(path ="/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId){
		User u = this.userService.getUser(userId);
		if(u != null) {
			return ResponseEntity.ok(u);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(path ="/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable int username){
		User u = this.userService.getUser(username);
		if(u != null) {
			return ResponseEntity.ok(u);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		List<User> users = this.userService.getAllUsers();
		
		if(users != null) {
			return ResponseEntity.ok(users);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Probably not needed
//	@GetMapping
//	public ResponseEntity<User> checkLogin(HttpSession session){
//		User supposedLoggedInUser = (User) session.getAttribute("user");
//		if (supposedLoggedInUser == null) {
//			return ResponseEntity.badRequest().build();
//		}
//		return ResponseEntity.ok(supposedLoggedInUser);
//	}
	
	@PutMapping
	public ResponseEntity<User> logIn(@RequestParam("user") String username,
			@RequestParam("pass") String password){
		User User = userService.getUserByUsername(username);
		if (User != null) {
			if (User.getPassword().equals(password)) {
				return ResponseEntity.ok(User);
			}
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateuser(@PathVariable("id") Integer id, @RequestBody User user)
	{
		System.out.println(id + " " + user.getUserid());
		if(user.getUserid() == id) {
			userService.updateUser(user);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
//This method should only be used by the teacher if at all
//	@PostMapping
//	public ResponseEntity<User> registerUser(@RequestBody User User) {
//		userService.addUser(User);
//		return ResponseEntity.ok(User);
//	}
	
	
	@DeleteMapping
	public ResponseEntity<Void> logOut(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
		userService.deleteUser(userService.getUser(id));
		return ResponseEntity.ok().build();
	}
}

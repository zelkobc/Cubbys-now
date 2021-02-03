package com.revature.controllers;

import com.revature.services.*;
import com.revature.beans.*;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Component
@RequestMapping(path = "/messages")
public class MessageController {
	
	private final MessageService messageService;
	private final UserService userService;
	
	@Autowired
	public MessageController(MessageService messageService, UserService userService) {
		this.messageService = messageService;
		this.userService = userService;
	}
	@GetMapping(path = "/{messageId}")
	public ResponseEntity<Messages> getMessageById(@PathVariable int messageId) {
//		add @RequestBody User user and HttpSession session to args for basic auth
//		User loggedUser = (User) session.getAttribute("user");
		Messages message = this.messageService.getMessageById(messageId);
//		if(loggedUser != null && (loggedUser.getUserid().equals(message.getWriterid())) || loggedUser != null && (loggedUser.getUserid().equals(message.getReceiverid()))) { check password and id for uniqueness; maybe just another ||
		if(message != null) {
			return ResponseEntity.ok(message);
		} else {
			return ResponseEntity.notFound().build();
		}
//		 else {
//		 return ResponseEntity.badRequest.build();
//		}
//	}
	}
	@GetMapping(path = "/user/{ReceiverId}")
	public ResponseEntity<List<Messages>> getMessagesByReceiver(@PathVariable int ReceiverId) {
		Integer usrId = this.userService.getUser(ReceiverId).getUserid();
		if (usrId != null) {
		List<Messages> messages = this.messageService.getAllMessagesByReceiverId(ReceiverId);
		return ResponseEntity.ok(messages);
		} else {
		return ResponseEntity.badRequest().build(); 
		}
	}
	@PostMapping
	public ResponseEntity<Integer> addMessage(@RequestBody Messages message)
	{
		Integer newId = this.messageService.addMessages(message);
		if (newId != null)
		{
			return ResponseEntity.ok(message.getId());
		}
		return ResponseEntity.badRequest().build();
	}
	@PutMapping
	public void updateMessage(@RequestBody Messages message) {
		Integer Id = message.getId();
		if (this.messageService.getMessageById(Id) != null) {
			this.messageService.updateMessage(message);
		} else {
		return;
		}
	}
	@DeleteMapping("/{id}") //100 MILLION PERCENT REQUIRES AUTHORIZATION AT SOME POINT PLS PLS PLS 
	public ResponseEntity<Void> deleteMessage(@PathVariable Integer id)
	{
		this.messageService.deleteMessage(id);
		return ResponseEntity.ok().build();
	}
}

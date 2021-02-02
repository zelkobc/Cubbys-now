package com.revature.controllers;

import com.revature.services.*;
import com.revature.beans.*;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Component
@RequestMapping(path = "/messages")
public class MessageController {
	
	private final MessageService messageService;
	
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	@GetMapping(path = "/{messageId}")
	public ResponseEntity<Messages> getMessageById(@PathVariable int messageId) {
//		add @RequestBody User user and HttpSession session to args for basic auth
//		User loggedUser = (User) session.getAttribute("user");
		Messages message = this.messageService.getMessageById(messageId);
//		if(loggedUser != null && (loggedUser.getUserid().equals(message.getWriterid())) || loggedUser != null && (loggedUser.getUserid().equals(message.getReceiverid()))) {
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
	@DeleteMapping("/{id}") //100 MILLION PERCENT REQUIRES AUTHORIZATION AT SOME POINT PLS PLS PLS 
	public ResponseEntity<Void> deleteMessage(@PathVariable Integer id)
	{
		this.messageService.deleteMessage(id);
		return ResponseEntity.ok().build();
	}
}

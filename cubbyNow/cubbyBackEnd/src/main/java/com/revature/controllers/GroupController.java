package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Group;
import com.revature.services.GroupService;

@RestController
@RequestMapping(path ="/groups")
public class GroupController {

	private GroupService groupServ;
	@Autowired
	public GroupController(GroupService groupServ)
	{
		this.groupServ = groupServ;
	}
	
	@PostMapping
	public ResponseEntity<Integer> addGroup(@RequestBody Group group)
	{
		Integer result = groupServ.addGroup(group);
		
		if (result != null)
		{
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Group> getGroupById(@PathVariable Integer id)
	{
		Group result = groupServ.getGroupById(id);
		if (result != null)
		{
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().build();
	}
}

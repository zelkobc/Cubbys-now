package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.revature.beans.Group;
import com.revature.services.GroupService;

@RestController
@RequestMapping(path ="/groups")
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
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
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> updateGroup(@RequestBody Group group)
	{
		if (groupServ.updateGroup(group))
		{
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Group>> getAllGroups()
	{
		return ResponseEntity.ok(groupServ.getAllGroups());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGroup(@PathVariable Integer id)
	{
		groupServ.deleteGroupById(id);
		return ResponseEntity.ok().build();
	}
}

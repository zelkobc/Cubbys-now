package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping(path ="/posts")
public class PostController {

	private PostService postServ;
	
	@Autowired
	public PostController(PostService postServ)
	{
		this.postServ = postServ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Integer id)
	{
		Post result = postServ.getPostById(id);
		if (result != null)
		{
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Post>> getAllPosts()
	{
		return ResponseEntity.ok(postServ.getAllPosts());
	}
	
	@PostMapping
	public ResponseEntity<Integer> addPost(@RequestBody Post post)
	{
		Integer newId = postServ.addPost(post);
		if (newId != null)
		{
			return ResponseEntity.ok(newId);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping
	public ResponseEntity<Void> updatePost(@RequestBody Post post)
	{
		postServ.updatePost(post);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletePost(@RequestBody Post post)
	{
		postServ.deletePost(post);
		return ResponseEntity.ok().build();
	}
}

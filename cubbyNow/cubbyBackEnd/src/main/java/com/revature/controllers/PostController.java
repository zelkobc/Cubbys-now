package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.revature.beans.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping(path ="/posts")
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
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

	@GetMapping("/public")
	public ResponseEntity<List<Post>> getPublicPosts(){
	  return ResponseEntity.ok(postServ.getPublicPosts());
	}
	
  @GetMapping("/groups/{groupId}")
  public ResponseEntity<List<Post>> getGroupPosts(@PathVariable Integer groupId){
    return ResponseEntity.ok(postServ.getGroupPosts(groupId));
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer id)
	{
		postServ.deletePost(id);
		return ResponseEntity.ok().build();
	}
}

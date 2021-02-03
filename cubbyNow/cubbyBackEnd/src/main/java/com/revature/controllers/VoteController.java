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
import com.revature.beans.Vote;
import com.revature.services.VoteService;
import com.revature.beans.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping(path="/posts/votes")
public class VoteController {
	
	private VoteService voteServ;
	private PostService postServ;
	
	@Autowired
	public VoteController(VoteService voteServ) {
		this.voteServ = voteServ;
		this.postServ = postServ;
	}
//	@GetMapping("/{postid}")
//	public ResponseEntity<Vote> getVotesByPost(@PathVariable Integer postid) {
//		Post post = postServ.getPostById(postid);
//		if (post != null) {
//		}
//	}
	

}

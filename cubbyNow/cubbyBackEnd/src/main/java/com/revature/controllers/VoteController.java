package com.revature.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.revature.beans.User;
import com.revature.services.PostService;

@RestController
@RequestMapping(path="/posts/votes")
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
public class VoteController {
	
	private VoteService voteServ;
	private PostService postServ;
	
	@Autowired
	public VoteController(VoteService voteServ) {
		this.voteServ = voteServ;
		this.postServ = postServ;
	}
	@GetMapping("/{postid}")
	public ResponseEntity<List<Vote>> getVotesByPost(@PathVariable Integer postid) {

			List<Vote> votes = this.voteServ.getAllVotesByPost(postid);
			if (votes != null) {
				return ResponseEntity.ok(votes);
			} else {
				return ResponseEntity.notFound().build();
			}

	}
	@PostMapping
	public ResponseEntity<Integer> addVote(@RequestBody Vote vote) {
		Integer newId = this.voteServ.addVote(vote);
		if (newId != null) {
			return ResponseEntity.ok(vote.getVoteid());
		} return ResponseEntity.badRequest().build();
	}
	@PutMapping
	public void updateVote(@RequestBody Vote vote) {
		Integer id = vote.getVoteid();
		if (this.voteServ.getVoteById(id) != null) {
			this.voteServ.updateVote(vote);
			return;
		}
		return;
	}
	@GetMapping("/check/{postid}/{userid}")
	public ResponseEntity<Boolean> hasVoted(@PathVariable Integer userid, @PathVariable Integer postid) {
		if (this.voteServ.hasVoted(userid, postid) == true) {
			return ResponseEntity.ok(true);
		}	return ResponseEntity.ok(false);
	}
}

package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Service;
import com.revature.beans.Vote;
import com.revature.data.VoteDAO;
import com.revature.data.PostDAO;
import com.revature.beans.Post;

@Service
public class VoteService {
	private VoteDAO voteDAO;
	private PostDAO postDAO;
	
	@Autowired
	public VoteService(VoteDAO voteDAO, PostDAO postDAO) {
		this.postDAO = postDAO;
		this.voteDAO = voteDAO;
	}
	public Vote getVoteById(Integer id) {
		return voteDAO.findById(id).get();
	}
	@EntityGraph(value="Vote.postid", type= EntityGraphType.FETCH)
	public List<Vote>getAllVotesByPost(Integer postid){
		return voteDAO.findByPostid(postid);
	}
	public Integer addVote(Vote vote) {
		if(!voteDAO.existsById(vote.getVoteid()) && postDAO.existsById(vote.getPostid())) {
			return voteDAO.save(vote).getVoteid();
		}
		return null;
	}
	public void updateVote(Vote vote)
	{
		if (voteDAO.existsById(vote.getVoteid()) && postDAO.existsById(vote.getPostid())) {
			voteDAO.save(vote);
		}
	}
	// Don't think we'll ever delete votes through backend?
	

}

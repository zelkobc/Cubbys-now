package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Service;
import com.revature.beans.Vote;
import com.revature.data.VoteDAO;
import com.revature.data.PostDAO;
import com.revature.data.UserDAO;
import com.revature.beans.Post;
import com.revature.beans.User;

@Service
public class VoteService {
	private UserDAO userDAO;
	private VoteDAO voteDAO;
	private PostDAO postDAO;
	
	@Autowired
	public VoteService(VoteDAO voteDAO, PostDAO postDAO, UserDAO userDAO) {
		this.postDAO = postDAO;
		this.voteDAO = voteDAO;
		this.userDAO = userDAO;
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
		return 1;
	}
	public void updateVote(Vote vote)
	{
		if (voteDAO.existsById(vote.getVoteid()) && postDAO.existsById(vote.getPostid())) {
			voteDAO.save(vote);
		}
	}
	public boolean hasVoted(User user, Integer postid) { // takes in a vote, checks the votes for the post it applies to and sees if the voting user has voted before.
		List<Vote> votes = getAllVotesByPost(postid);
		if(votes != null) {
		for(int i = 0; i < votes.size(); i++) {
			if (votes.get(i).getUserid() == user.getid()) {
				return true;
			}
		}
		} return false;
	}
}

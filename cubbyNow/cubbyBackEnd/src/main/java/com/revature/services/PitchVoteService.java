package com.revature.services;

import java.util.List;

import com.revature.beans.PitchVote;
import com.revature.data.PitchVoteDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PitchVoteService{
  private PitchVoteDAO pitchVoteDAO;

  @Autowired
  public PitchVoteService(PitchVoteDAO temp){
    pitchVoteDAO = temp;
  }

  // Create
  public Integer addPitchVote(PitchVote pv){
    pitchVoteDAO.save(pv).getVoteid();
    return pv.getVoteid();
  }

  // Read
  public PitchVote getPitchVoteById(Integer id){
    return pitchVoteDAO.findById(id).get();
  }

  public List<PitchVote> getAllPitchVotes(){
    return pitchVoteDAO.findAll();
  }

  // Update
  public void updatePitchVote(PitchVote pv){
    pitchVoteDAO.save(pv);
  }
  
  // Delete
  public void deletePitchVote(Integer id){
    pitchVoteDAO.deleteById(id);
  }

}

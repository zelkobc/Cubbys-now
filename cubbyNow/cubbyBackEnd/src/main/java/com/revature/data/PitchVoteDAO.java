package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.PitchVote;

public interface PitchVoteDAO extends JpaRepository<PitchVote, Integer>{
}

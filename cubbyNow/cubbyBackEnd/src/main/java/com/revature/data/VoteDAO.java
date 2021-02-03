package com.revature.data;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.beans.Vote;

public interface VoteDAO extends JpaRepository<Vote, Integer>{
	List<Vote> findByPostid(Integer postid);

}

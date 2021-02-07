package com.revature.pitcherizer.pitchPlus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;

import org.mockito.InjectMocks;
import com.revature.beans.Vote;
import com.revature.data.VoteDAO;
import com.revature.services.VoteService;
import com.revature.beans.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.junit.MockitoJUnitRunner;

@ExtendWith(MockitoExtension.class)
public class voteTests {
	@Mock
	static VoteDAO voteDao;
	@Mock 
	VoteService voteServiceMock;
	
	@InjectMocks
	static Integer userSequenceMock = 1;
	static Post mockPost = new Post();
	Vote v = new Vote();
	
	@Test
	public void testFindByPostId() {
		ArrayList<Vote> list = new ArrayList<Vote>();
		v.setVoteid(2);
		v.setUserid(3);
		v.setRating(1);
		v.setPostid(1);
		list.add(v);
		when(voteDao.findByPostid(1)).thenReturn(list);
		assertEquals(v, list.get(0));
	}
	
}

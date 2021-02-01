package com.revature.pitcherizer.pitchPlus;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.services.UserService;

@ExtendWith(MockitoExtension.class)
public class userTests {
	static UserDAO userDao;

	
@InjectMocks
static UserService userServ;
static Set<User> userMock = new HashSet<>();
static Integer userSeq = 1;
@Test
public void addUsertest() { // This isn't really covering anything lol, effectively just setting space
		User u = new User();
		u.setuserid(2);
		userMock.add(u);
		User u2 = new User();
		u2.setuserid(userSeq++);
	}
}

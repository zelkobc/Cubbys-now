package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Messages;
import com.revature.beans.User;

public interface MessageDAO extends JpaRepository<Messages, Integer> {
	List<Messages> findByReceiver(User receiver);

}

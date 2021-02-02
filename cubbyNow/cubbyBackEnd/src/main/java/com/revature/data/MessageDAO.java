package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Messages;

public interface MessageDAO extends JpaRepository<Messages, Integer> {
	List<Messages> findByReceiverid(Integer receiverid);

}

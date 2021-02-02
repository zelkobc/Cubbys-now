package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Messages;

public interface MessageDAO extends JpaRepository<Messages, Integer> {

}

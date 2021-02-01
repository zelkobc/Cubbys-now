package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	public User findUserByName(String username);
}

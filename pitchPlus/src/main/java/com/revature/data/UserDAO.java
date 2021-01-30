package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Users;

@Repository
public interface UserDAO extends JpaRepository<Users, Integer> {
	public Users findUserByName(String username);
}

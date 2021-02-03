package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Group;

@Repository
public interface GroupDAO extends JpaRepository<Group, Integer> {

}

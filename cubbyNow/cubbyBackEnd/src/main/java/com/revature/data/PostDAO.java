package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Post;

public interface PostDAO extends JpaRepository<Post, Integer> {

}

package com.revature.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Post;
import com.revature.data.PostDAO;

@Service
public class PostService {
	private PostDAO postDAO;
	
	@Autowired
	public PostService(PostDAO postDAO)
	{
		this.postDAO = postDAO;
	}
	
	public Post getPostById(Integer id)
	{
		return postDAO.findById(id).get();
	}
	
	public List<Post> getAllPosts()
	{
		return postDAO.findAll();
	}

	public List<Post> getPublicPosts(){
	  List<Post> publicPosts = new LinkedList<Post>();
	  List<Post> allPosts = getAllPosts();
	  for(Post post : allPosts){
      if(post.getGroupid() == null){
        publicPosts.add(post);
      }
	  }
	  return publicPosts;
	}
	
	public List<Post> getGroupPosts(Integer groupId){
	  List<Post> allPosts = getAllPosts();
	  List<Post> groupPosts = new LinkedList<Post>(); 
	  for(Post post : allPosts){
	    if(post.getGroupid() == groupId){
        groupPosts.add(post);
      }
	  }
	  return groupPosts;
	}
	
	public Integer addPost(Post post)
	{
		if (!postDAO.existsById(post.getPostid()))
		{
			return postDAO.save(post).getPostid();
		}
		return null;
		
	}
	
	public void updatePost(Post post)
	{
		if (postDAO.existsById(post.getPostid()))
		{
			postDAO.save(post);
		}
	}
	
	public void deletePost(Integer id)
	{
		Post post = postDAO.findById(id).get();
		postDAO.delete(post);
	}

}

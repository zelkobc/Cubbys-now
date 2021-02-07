package com.revature.services;

import java.util.LinkedList;
import java.util.List;

import com.revature.beans.Post;
import com.revature.beans.Reply;
import com.revature.data.ReplyDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyService{
  private ReplyDAO replyDAO;
  private PostService postServ;

  @Autowired
  ReplyService(ReplyDAO r){
    replyDAO = r;
  }

  // Create
  public Integer addReply(Reply reply){
    return replyDAO.save(reply).getId();
  }

  // Read
  public Reply getReplyById(Integer id){
    return replyDAO.findById(id).get();
  }

  public List<Reply> getAllReplies(){
    return replyDAO.findAll();
  }

  public List<Reply> getRepliesByPost(Integer id){
    //Post post = postServ.getPostById(id);
    List<Reply> allReplies = getAllReplies();
    List<Reply> postReplies = new LinkedList<Reply>();
    for(Reply r : allReplies){
      if(r.getPost().getPostid() == id){
        postReplies.add(r);
      }
    }
    return postReplies;
  }

  // Update
  public void updateReply(Reply reply){
    replyDAO.save(reply);
  }

  // Delete
  public void deleteReply(Integer id){
    replyDAO.deleteById(id);
  }

}

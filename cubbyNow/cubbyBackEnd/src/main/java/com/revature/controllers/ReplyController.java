package com.revature.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.revature.beans.Reply;
import com.revature.services.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/replies")
public class ReplyController{
  private ReplyService replyServ;

  @Autowired
  public ReplyController(ReplyService r){
    replyServ = r;
  }

  // Create
  @PostMapping
  public ResponseEntity<Integer> addReply(@RequestBody Reply reply){
      Reply check = null; 
	    try{
	        check = replyServ.getReplyById(reply.getId());
	        System.out.println(check);
	    }
	    catch(Exception e){
	    }
	    if(check == null){
	        return ResponseEntity.ok(replyServ.addReply(reply));
	    } 
	    else{
	        return ResponseEntity.badRequest().build();
	    }
  }

  // Read
  @GetMapping(path = "/{id}")
  public ResponseEntity<Reply> getReplyById(@PathVariable("id") Integer id){
    return ResponseEntity.ok(replyServ.getReplyById(id));
  }

  @GetMapping
  public ResponseEntity<List<Reply>> getAllReplies(){
    return ResponseEntity.ok(replyServ.getAllReplies());
  }

  @GetMapping(path = "/posts/{id}")
  public ResponseEntity<List<Reply>> getRepliesByPost(@PathVariable("id") Integer id){
    return ResponseEntity.ok(replyServ.getRepliesByPost(id));
  }

  // Update
  @PutMapping
  public ResponseEntity<Void> updateReply(@RequestBody Reply reply){
    if(replyServ.getReplyById(reply.getId()) != null){
      replyServ.updateReply(reply);
      return ResponseEntity.ok().build();
    }
    else{
      return ResponseEntity.notFound().build();
    }
  }

  // Delete
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteReply(@PathVariable("id") Integer id){
    replyServ.deleteReply(id);
    return ResponseEntity.ok().build();
  }

}

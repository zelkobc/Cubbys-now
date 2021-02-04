package com.revature.beans;
import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="Replies")
public class Reply{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String message;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "post_id")
  private Post post;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id")
  private User author;

  public Reply(){
  }

  public Integer getId(){
    return id;
  }
  
  public void setId(Integer i){
    id = i;
  }

  public String getMessage(){
    return message;
  }

  public void setMessage(String s){
    message = s;
  }
  
  public Post getPost(){
    return post;
  }

  public void setPost(Post p){
    post = p;
  }

  public User getAuthor(){
    return author;
  }

  public void setAuthor(User u){
    author = u;
  }
}

package com.revature.beans;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reply other = (Reply) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Reply [id=" + id + ", message=" + message + ", post=" + post + ", author=" + author + "]";
	}
  
}

package com.revature.beans;

import javax.persistence.*;


@Entity
@Table(name="post")
public class Post {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postid;
	@OneToOne(targetEntity=User.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="users")
	private int authorid;
	@Column(name="pcontent")
	private String content;
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorid;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + postid;
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
		Post other = (Post) obj;
		if (authorid != other.authorid)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (postid != other.postid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Post [postid=" + postid + ", authorid=" + authorid + ", content=" + content + "]";
	}
	public Post() {
		postid = 0;
		authorid = 0;
		content = "";
	}
}

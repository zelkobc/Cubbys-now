package com.revature.beans;

import javax.persistence.*;


@Entity
@Table(name="posts")
public class Post {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postid;
	
	//@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	//@JoinColumn(name="author_id")
	@Column(name="author_id")
	private Integer authorid;
	
	@Column(name="pcontent")
	private String content;
	
	public Integer getPostid() {
		return postid;
	}
	public void setPostid(Integer postid) {
		this.postid = postid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	public Integer getAuthorid() {
		return authorid;
	}
	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}
	
	
	
	@Override
	public String toString() {
		return "Post [postid=" + postid + ", authorid=" + authorid + ", content=" + content + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorid == null) ? 0 : authorid.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((postid == null) ? 0 : postid.hashCode());
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
		if (authorid == null) {
			if (other.authorid != null)
				return false;
		} else if (!authorid.equals(other.authorid))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (postid == null) {
			if (other.postid != null)
				return false;
		} else if (!postid.equals(other.postid))
			return false;
		return true;
	}
	public Post() {
		postid = 0;
		authorid = -1;
		content = "";
	}
}

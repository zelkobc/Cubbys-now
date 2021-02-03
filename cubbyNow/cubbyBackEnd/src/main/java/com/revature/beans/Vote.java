package com.revature.beans;

import javax.persistence.*;

import org.hibernate.annotations.Check;

@Entity
@Table(name="votes")
public class Vote {

	@Id
	@Column(name="vote_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer voteid;
	@Column(name="post_id")
	private Integer postid;
	@Column(name="user_id")
	private Integer userid;
	@Column(name="votevalue")
	@Check(constraints = "votevalue <= 10")
	private Integer rating;

	
@Override
	public String toString() {
		return "PitchVote [pitchid=" + postid + ", userid=" + userid + ", rating=" + rating + ", voteid=" + voteid
				+ "]";
	}

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postid;
		result = prime * result + rating;
		result = prime * result + userid;
		result = prime * result + voteid;
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
		Vote other = (Vote) obj;
		if (postid != other.postid)
			return false;
		if (rating != other.rating)
			return false;
		if (userid != other.userid)
			return false;
		if (voteid != other.voteid)
			return false;
		return true;
	}



public Integer getVoteid() {
		return voteid;
	}

	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

public Vote() {
	postid = 0;
	userid = 0;
	rating = 0;
	voteid= 0;
}
}

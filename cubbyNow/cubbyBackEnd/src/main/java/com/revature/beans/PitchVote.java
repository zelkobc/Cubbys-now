package com.revature.beans;

import javax.persistence.*;

import org.hibernate.annotations.Check;

@Entity
@Table(name="votes")
public class PitchVote {

	@Id
	@Column(name="vote_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int voteid;
	@ManyToOne(targetEntity=Posts.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private int pitch_id;
	@ManyToOne(targetEntity=User.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private int user_id;
	@Column(name="votevalue")
	@Check(constraints = "votevalue <= 100")
	private int rating;

	
@Override
	public String toString() {
		return "PitchVote [pitchid=" + pitch_id + ", userid=" + user_id + ", rating=" + rating + ", voteid=" + voteid
				+ "]";
	}

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pitch_id;
		result = prime * result + rating;
		result = prime * result + user_id;
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
		PitchVote other = (PitchVote) obj;
		if (pitch_id != other.pitch_id)
			return false;
		if (rating != other.rating)
			return false;
		if (user_id != other.user_id)
			return false;
		if (voteid != other.voteid)
			return false;
		return true;
	}

public int getPitchid() {
		return pitch_id;
	}

	public void setPitchid(int pitchid) {
		this.pitch_id = pitchid;
	}

	public int getUserid() {
		return user_id;
	}

	public void setUserid(int userid) {
		this.user_id = userid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getVoteid() {
		return voteid;
	}

	public void setVoteid(int voteid) {
		this.voteid = voteid;
	}

public PitchVote() {
	pitch_id = 0;
	user_id = 0;
	rating = 0;
	voteid= 0;
}
}

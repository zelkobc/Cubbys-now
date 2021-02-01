package com.revature.beans;

import javax.persistence.*;

import org.hibernate.annotations.Check;

@Entity
@Table(name="votes")
public class PitchVote {
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="pitches")
	private int pitchid;
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="users")
	private int userid;
	@Column(name="votevalue")
	@Check(constraints = "votevalue <= 100")
	private int rating;
	@Id
	@Column(name="vote_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int voteid;
	
@Override
	public String toString() {
		return "PitchVote [pitchid=" + pitchid + ", userid=" + userid + ", rating=" + rating + ", voteid=" + voteid
				+ "]";
	}

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pitchid;
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
		PitchVote other = (PitchVote) obj;
		if (pitchid != other.pitchid)
			return false;
		if (rating != other.rating)
			return false;
		if (userid != other.userid)
			return false;
		if (voteid != other.voteid)
			return false;
		return true;
	}

public int getPitchid() {
		return pitchid;
	}

	public void setPitchid(int pitchid) {
		this.pitchid = pitchid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
	pitchid = 0;
	userid = 0;
	rating = 0;
	voteid= 0;
}
}

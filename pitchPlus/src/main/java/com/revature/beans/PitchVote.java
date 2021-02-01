package com.revature.beans;

import javax.persistence.*;

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
	private int rating;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pitchid;
		result = prime * result + rating;
		result = prime * result + userid;
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
		return true;
	}
	@Override
	public String toString() {
		return "PitchVote [pitchid=" + pitchid + ", userid=" + userid + ", rating=" + rating + "]";
	}

public PitchVote() {
	pitchid = 0;
	userid = 0;
	rating = 0;
}
}

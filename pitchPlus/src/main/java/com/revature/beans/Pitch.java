package com.revature.beans;

import javax.persistence.*;


@Entity
@Table(name="pitches")
public class Pitch {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pitchid;
	@OneToOne(mappedBy="users", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private int authorid;
	@Column(name="content")
	private String content;
	public int getPitchid() {
		return pitchid;
	}
	public void setPitchid(int pitchid) {
		this.pitchid = pitchid;
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
		result = prime * result + pitchid;
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
		Pitch other = (Pitch) obj;
		if (authorid != other.authorid)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (pitchid != other.pitchid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pitch [pitchid=" + pitchid + ", authorid=" + authorid + ", content=" + content + "]";
	}
	public Pitch() {
		pitchid = 0;
		authorid = 0;
		content = "";
	}
}

package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="groups")
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToMany
	@JoinTable(name = "groups_users", 
    joinColumns = { @JoinColumn(name = "group_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private Set<Integer> memberIds;
	
	public Group()
	{
		id = -1;
		memberIds = new HashSet<Integer>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Integer> getMemberIds() {
		return memberIds;
	}

	public void setMemberIds(Set<Integer> memberIds) {
		this.memberIds = memberIds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memberIds == null) ? 0 : memberIds.hashCode());
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
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memberIds == null) {
			if (other.memberIds != null)
				return false;
		} else if (!memberIds.equals(other.memberIds))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", memberIds=" + memberIds + "]";
	}
	
	
}

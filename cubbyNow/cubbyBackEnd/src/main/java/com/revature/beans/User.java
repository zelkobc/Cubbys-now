package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userid;
	@Column(name="username")
	private String name;
	@Column(name="passwrd")
	@JsonIgnore
	private String password; 
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="role_id")	
	private Role role;
	
	@ManyToMany
	@JoinTable(name = "groups_users", 
    joinColumns = { @JoinColumn(name = "user_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "group_id") })
	private Set<Group> groups;

	


	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", password=" + password + ", role=" + role + ", groups="
				+ groups + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		User other = (User) obj;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}




	public Set<Group> getGroups() {
		return groups;
	}




	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}




	public Integer getUserid() {
		return userid;
	}




	public void setUserid(Integer userid) {
		this.userid = userid;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Role getRole() {
		return role;
	}




	public void setRole(Role role) {
		this.role = role;
	}




public User() {
		userid = 0;
		name = "";
		password = "";
		role = new Role() ;
	}

}
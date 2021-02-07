package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="passwrd")
	@JsonProperty(access = Access.WRITE_ONLY)
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
<<<<<<< HEAD
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", role=" + role + ", groups="
=======
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", groups="
>>>>>>> 6a43135c47fbfd518bb80b55fca99956b022ca6c
				+ groups + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	public Set<Group> getGroups() {
		return groups;
	}




	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}




	public Integer getid() {
		return id;
	}




	public void setid(Integer id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
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
<<<<<<< HEAD
		userid = 0;
=======
		id = 0;
>>>>>>> 6a43135c47fbfd518bb80b55fca99956b022ca6c
		username = "";
		password = "";
		role = new Role() ;
	}

}

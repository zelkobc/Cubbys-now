package com.revature.beans;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column(name="username")
	private String name;
	@Column(name="passwrd")
	private String password; 
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="role_id")	
	private Role role_id;

	

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
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
		User other = (User) obj;
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
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", password=" + password + ", role_id=" + role_id + "]";
	}

public Integer getuserid() {
	return userid;
}

public void setuserid(Integer id) {
	this.userid = id;
}

public String getUsername() {
	return name;
}

public void setUsername(String username) {
	this.name = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Role getRole_id() {
	return role_id;
}

public void setRole_id(Role role_id) {
	this.role_id = role_id;
}



public User() {
		userid = 0;
		name = "";
		password = "";
		role_id = new Role() ;
	}

}
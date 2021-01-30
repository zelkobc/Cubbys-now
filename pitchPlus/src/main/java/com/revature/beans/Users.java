package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="users", schema="pitchplus")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private Integer id;
	@Column(name="username")
	private String name;
	@Column(name="passwrd")
	private String password;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="user_roles")
	private Role role_id;

public Integer getId() {
return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getUsername() {
	return getUsername();
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



public Users() {
		id = 0;
		name = "";
		password = "";
		role_id = new Role() ;
	}

}
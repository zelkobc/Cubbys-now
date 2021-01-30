package com.revature.beans;

import javax.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@Table(name="user_roles")
public class Role {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="role_id")
private Integer id;
private String name;

public Role() {
	id = 0;
	name = "";
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}

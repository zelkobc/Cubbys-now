package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.beans.Role;

@Repository
@Component
public interface RoleDAO extends JpaRepository<Role, Integer>{

}

package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Group;
import com.revature.data.GroupDAO;

@Service
public class GroupService {

	private GroupDAO groupDAO;
	
	@Autowired
	public GroupService(GroupDAO groupDAO)
	{
		this.groupDAO = groupDAO;
	}
	
	public Integer addGroup(Group group)
	{
		return groupDAO.save(group).getId();
	}
	
	public Group getGroupById(Integer id)
	{
		return groupDAO.findById(id).get();
	}
}

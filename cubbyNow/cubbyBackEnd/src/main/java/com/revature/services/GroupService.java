package com.revature.services;

import java.util.List;

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
	
	public List<Group> getAllGroups()
	{
		return groupDAO.findAll();
	}
	
	public boolean updateGroup(Group group)
	{
		if (groupDAO.existsById(group.getId()))
		{
			groupDAO.save(group);
			return true;
		}
		return false;
	}
	
	public void deleteGroupById(Integer id)
	{
		groupDAO.deleteById(id);
	}
}

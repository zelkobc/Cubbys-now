package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Service;

import com.revature.beans.Messages;
import com.revature.beans.User;
import com.revature.data.MessageDAO;

@Service
public class MessageService {
	private final MessageDAO messageDAO;
	
	@Autowired
	public MessageService(MessageDAO messageDAO){
		this.messageDAO = messageDAO;
	}
	public Messages getMessageById(Integer id)
	{
		return messageDAO.findById(id).get();
	}
	public List<Messages> getAllMessages(){
		return messageDAO.findAll();
	}
	@EntityGraph(value="Messages.receiver", type = EntityGraphType.FETCH)
	public List<Messages> getAllMessagesByReceiver(User receiver) {
		return messageDAO.findByReceiver(receiver);
	}
	public Integer addMessages(Messages message) {
		if (!messageDAO.existsById(message.getId())) {
			return messageDAO.save(message).getId();
		} 
		return null;
	}
	public void updateMessage(Messages message)
	{
		if (messageDAO.existsById(message.getId()))
		{
			messageDAO.save(message);
		}
	}
	public void deleteMessage(Integer id)
	{
		Messages message = messageDAO.findById(id).get();
		messageDAO.delete(message);
	}
}

package com.revature.Handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class PostWebSocketHandler extends TextWebSocketHandler {

	public static Map<Integer, WebSocketSession> websockets = new HashMap<>();
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		if (getQueryValue(session.getUri().getQuery(),"persid")!=null)
		{
			websockets.put(Integer.parseInt(getQueryValue(session.getUri().getQuery(),"persid")), session);
		}
		else
		{
			System.out.println("Invalid ID provied for post websocket, cancelling");
			session.close(CloseStatus.BAD_DATA);
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		//remove session from map if present
		if (websockets.containsValue(session))
		{
			for (Map.Entry<Integer, WebSocketSession> entry: websockets.entrySet())
			{
				if(entry.getValue().equals(session))
				{
					websockets.remove(entry.getKey());
				}
			}
		}
	}
	
	private String getQueryValue(String query, String param)
	{
		if(query.contains(param))
		{
			return query.substring(query.indexOf(param) + param.length() + 1);
		}
		return null;
		
		
	}
}

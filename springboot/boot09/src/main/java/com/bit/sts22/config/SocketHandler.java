package com.bit.sts22.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SocketHandler extends TextWebSocketHandler {

	private List<WebSocketSession> list = new ArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 소켓 연결 되었을때
		list.add(session);
		System.out.println(list.size());
		System.out.println(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession socketSession : list) {
			socketSession.sendMessage(message);
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// 소켓 끊였을 때. 
		list.remove(session);
		System.out.println(list.size());
	}
	

}

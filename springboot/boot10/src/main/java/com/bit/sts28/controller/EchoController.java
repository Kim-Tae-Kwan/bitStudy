package com.bit.sts28.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.bit.sts28.domain.Message;

@Controller
public class EchoController {
	
	@MessageMapping("/room")
	@SendTo("/topic/msg1")
	public Message func01(Message msg) {
		System.out.println(msg);
		return msg;
	}
}

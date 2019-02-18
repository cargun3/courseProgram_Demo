package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.example.demo.bean.HandlerToken;

@Component
public class CommonComponent {
	@Autowired
	private HandlerToken handlerToken;
	@Autowired
	private MessageSource msg;
	
	public HandlerToken getHandlerToken() {
		return handlerToken;
	}
	
	public MessageSource getMsg() {
		return msg;
	}
}

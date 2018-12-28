package com.wisilica.wiseconnect1.service;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {
	
	void publish(String message, String channel);
	
	String getValue(String key);

}

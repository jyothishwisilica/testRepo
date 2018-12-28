package com.wisilica.wiseconnect1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.wisilica.wiseconnect1.service.MessageService;

@Service
public class RedisServiceImpl implements MessageService {	
	
	@Autowired
    private RedisTemplate< String, Object > redisTemplate;

	@Override
	public void publish(String message, String channel) {
		redisTemplate.convertAndSend(channel, message);
		System.out.println("Published messages to Redis");
	}

	@Override
	public String getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}

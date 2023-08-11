package com.samuel.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuel.hroauth.entities.User;
import com.samuel.hroauth.feignclients.UserFeignClients;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClients userFeignClients;
	
	public User findByEmail(String email) {
		User usuario = userFeignClients.findByEmail(email).getBody();
		
		if (usuario == null) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");	
		}

		logger.info("Email found: " + email);
		return usuario;
	}
}

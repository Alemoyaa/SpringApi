package com.application.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.application.common.CommonService;
import com.application.dtos.User;

@Service
public class UserService extends CommonService<User>{

	public UserService(RestTemplateBuilder restTemplateBuilder) {
		super(restTemplateBuilder);
	}

	public User[] getAllUsers() throws Exception{
		return getAll(User[].class, get_url() + "users");
	}
	
	public User getUser(long id) throws Exception{
		return getOne(id, User.class, get_url() + "users/{id}");
	}
	
}

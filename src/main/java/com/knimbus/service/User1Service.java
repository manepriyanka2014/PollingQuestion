package com.knimbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knimbus.dao.User1Mapper;
import com.knimbus.model.User1;


@Service
public class User1Service {
	
	@Autowired
	User1Mapper user1Mapper;
		
	public void createUser1(User1 user1) {
		user1Mapper.createUser1(user1);
	}

	public List<User1> getAllUser1() {
		List<User1> userList1 = user1Mapper.getAllUser1();
		return userList1;

	}


}

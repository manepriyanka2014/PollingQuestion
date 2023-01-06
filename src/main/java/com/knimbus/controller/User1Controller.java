package com.knimbus.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.knimbus.dao.User1Mapper;
import com.knimbus.model.User;
import com.knimbus.model.User1;
import com.knimbus.service.User1Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Api(tags = "This is user controller")
public class User1Controller {

	@Autowired
	User1Service user1Service;
	
	@Autowired
	User1Mapper user1Mapper;

	private static final String USER1 = "User1";
	private static final String USERlIST1 = "ListUser1";

	@ApiOperation(value = "Saves user details in Database")
	@RequestMapping(value = "/createUser1", method = RequestMethod.POST)
	public ResponseEntity<?> createUser1(
			@ApiParam(value = "Please enter the user details to be saved", required = true) @RequestBody User1 user1) {
		System.out.println("......Inside add poll user.........");
		user1Service.createUser1(user1);
		return new ResponseEntity<User1>(HttpStatus.OK);
	}
		
//	@ApiOperation(value = "Get User list")
//	@RequestMapping(value = "/pollUserList", method = RequestMethod.GET)
//	public ResponseEntity<?> showListOfUser1() {
//		System.out.println("......Inside user List......");
//		List<User1> userList1 = user1Service.getAllUser();
//		return new ResponseEntity<List<User1>>(userList1, HttpStatus.OK);
//	}
	
	@ApiOperation(value = "Login Poll User")
	@RequestMapping(value = "/loginPollUser", method = RequestMethod.POST)
	public ResponseEntity<?> loginPollUser(
			@ApiParam(value = "Please enter the user details to be saved", required = true) @RequestBody User1 user1) {
		System.out.println("--------Inside login poll user-----");
		System.out.println(user1.getEmail() + user1.getPassword());
		User1 user = user1Mapper.loginPollUser(user1);
		System.out.println("userName:" + user.getUserName());

		return new ResponseEntity<User1>(user, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get vote count")
	@RequestMapping(value = "/getVoteCount", method = RequestMethod.GET)
	public ResponseEntity<?> getVoteCount() 
	{
		System.out.println("Inside getVoteCount");
		HashMap<String, Object> map = user1Mapper.getVoteCount();
		return new ResponseEntity<HashMap>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get user details")
	@RequestMapping(value = "/getUserDetails/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(
			@ApiParam(value = "Please enter the userid to get user information", required = true) @PathVariable("userId") int userId) {
		System.out.println("Inside getUser");
		User1 user = user1Mapper.getUser(userId);
		return new ResponseEntity<User1>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update User vote")
	@RequestMapping(value = "/updateVote", method = RequestMethod.PUT)
	public ResponseEntity<?> updateVote(
			@ApiParam(value = "Please enter the user details to be update user vote", required = true) @RequestBody User1 user) {
		System.out.println("Inside updateUserVote");
		User1 updateUser = user1Mapper.updateUserVote(user);
		return new ResponseEntity<User1>(updateUser, HttpStatus.OK);
	}
	
}

package com.knimbus.controller;

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

import com.knimbus.model.CalenderInfo;
import com.knimbus.model.Question;
import com.knimbus.service.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Api(tags = "This is question controller")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	

	@ApiOperation(value = "Saves questios details in Database")
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public ResponseEntity<?> addQuestion(
			@ApiParam(value = "Please enter the question ", required = true) @RequestBody Question question) {
		System.out.println("--------------Inside Add Question-------------");
		
		questionService.addQuestion(question);
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete question")
	@RequestMapping(value = "/deleteQuestion/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteQuestion(
			@ApiParam(value = "Please enter the questionID which to be delete", required = true) @PathVariable("questionId") int questionId) {
		System.out.println("------------Inside delete--- question---------");
		questionService.deleteQuestion(questionId);

		return new ResponseEntity<Question>( HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get question list")
	@RequestMapping(value = "/listOfQuestion", method = RequestMethod.GET)
	public ResponseEntity<?> listOfQuestion() {
		System.out.println("......Inside Question List........");
		List<Question> questionList = questionService.getAllQuestion();
		return new ResponseEntity<List<Question>>(questionList, HttpStatus.OK);
	}	


}

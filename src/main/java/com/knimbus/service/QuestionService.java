package com.knimbus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knimbus.dao.QuestionMapper;
import com.knimbus.model.Question;
@Service
public class QuestionService {

	@Autowired
	QuestionMapper questionMapper;
		
	public void addQuestion(Question question) {
		questionMapper.addQuestion(question);

	}
	
	public void deleteQuestion(int questionId) {
		questionMapper.deleteQuestion(questionId);

	};
	
	public List<Question> getAllQuestion(){
		List<Question> questionList = questionMapper.getAllQuestion();
		return questionList;
	};
}

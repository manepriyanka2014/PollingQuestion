package com.knimbus.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private Long questionId;
	private String question;
	
	private  List<Options> options = new ArrayList<Options>();
	
	public Question() {
		
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

}

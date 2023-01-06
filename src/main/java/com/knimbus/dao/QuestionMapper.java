package com.knimbus.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.knimbus.model.Question;
import com.knimbus.model.User;
import com.knimbus.util.config.MyBatisUtil;

@Repository("questionMapper")
public class QuestionMapper {

	public void addQuestion(Question question) {
		System.out.println("-----------------------Inside Add Question-----------------");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("addQuestion", question);
		session.commit();
		session.close();
	}
	
	public void deleteQuestion(int questionId) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteQuestion", questionId);
		session.commit();
		session.close();
	}
	
	public List<Question> getAllQuestion(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		System.out.println("-----------------------Inside All question list-----------------");
		@SuppressWarnings("unchecked")
		List<Question> questionList = session.selectList("getAllQuestion");
		session.commit();
		session.close();
		System.out.println("User Count"+questionList.size());
		return questionList;
	}
	
}

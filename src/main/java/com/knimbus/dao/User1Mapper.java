package com.knimbus.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.knimbus.model.User;
import com.knimbus.model.User1;
import com.knimbus.util.config.MyBatisUtil;

@Repository
public class User1Mapper {

	public void createUser1(User1 user1) {
		System.out.println("-----------------------Inside Add user1-----------------");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("createUser1", user1);
		session.commit();
		session.close();
		
	}

	public List<User1> getAllUser1() {
			SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
			System.out.println("-----------------------Inside All user list-----------------");
			@SuppressWarnings("unchecked")
			List<User1> userList1 = session.selectList("getAllUser1");
			session.commit();
			session.close();
			System.out.println("User Count"+userList1.size());
			return userList1;
		}

	public User1 loginPollUser(User1 user1 ) {
		//System.out.println(user.getUserId()+"--"+ user.getPassword() );
		System.out.println("---------");
		System.out.println(user1.getEmail()+"--"+ user1.getPassword() );
//		String userName = "";
		System.out.println("-----------------------Inside loginPollUser-----------------");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		User1 user2 = (User1)session.selectOne("com.knimbus.dao.User1Mapper.validateUser1Credential1", user1);
		System.out.println(user2.toString());
		System.out.println(user2.getUserId());
	
		session.commit();
		session.close();
		return user2;		
	}
	
	
	@SuppressWarnings("unchecked")
	public HashMap<String,Object> getVoteCount( ) 
	{

		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
	      
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.clear();
		map= (HashMap<String,Object>)session.selectOne("com.knimbus.dao.User1Mapper.getVoteCout");
	    System.out.println("Details of the vote :" );
		session.commit();
		session.close();
		
		return map;
    
	}
	
	
	public User1 getUser(int userId){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
      
		User1 user = (User1) session.selectOne("com.knimbus.dao.User1Mapper.getById", userId);
	    System.out.println("Details of the user :" );
	    System.out.println(user.toString());   
	    
		session.commit();
		session.close();
    
	    return user;
	}
	
	public User1 updateUserVote(User1 user){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        System.out.println("Input user:"+ user.toString());
		session.update("com.knimbus.dao.User1Mapper.updateVote", user);
		User1 updatedUser = (User1) session.selectOne("com.knimbus.dao.User1Mapper.getById", user.getUserId());
	    System.out.println("Details of the user after update operation" );
	    System.out.println(updatedUser.toString());   
	    
		session.commit();
		session.close();
    
	    return updatedUser;
	}

	
}

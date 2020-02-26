package com.jjb.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jjb.model.UserVO;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.jjb.mapper.UserMapper";

	@Override
	public UserVO login(UserVO userVO) throws Exception {
		UserVO user= sqlSession.selectOne(namespace+".login",userVO);
		return user;
	}

	@Override
	public void signUp(UserVO user) throws Exception {
		sqlSession.insert(namespace+".signUp", user);		
	}

	@Override
	public String checkID(String userid) throws Exception {
		String checkedid = sqlSession.selectOne(namespace+".checkID",userid);
		return checkedid;
	}

	@Override
	public String checkNick(String nickname) throws Exception {
		String checkednick = sqlSession.selectOne(namespace+".checkNick",nickname);
		return checkednick;
	}

	@Override
	public String checkPW(String userid) throws Exception {
		String PwForCk = sqlSession.selectOne(namespace+".checkPW",userid);
		return PwForCk;
	}

	@Override
	public UserVO InfoFromId(String userid) throws Exception {
		UserVO user = sqlSession.selectOne(namespace+".InfoFromId",userid); 
		return user;
	}

	@Override
	public void changeInfo(UserVO user) throws Exception {
		sqlSession.update(namespace+".changeInfo",user);
	}

	@Override
	public void changePw(String newPw, String userid) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("newPw", newPw);
		paramMap.put("userid", userid);
		sqlSession.update(namespace+".changePw",paramMap);
		
	}

	@Override
	public void deleteUser(String userid) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".deleteUser",userid);
	}


}

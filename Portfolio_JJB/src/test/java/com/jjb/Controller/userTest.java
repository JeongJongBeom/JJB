package com.jjb.Controller;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jjb.mapper.UserMapper;
import com.jjb.model.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)//������ �Ҷ� SpringJUnit4ClassRunner Ŭ������ ���� ������ 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//context�� ����ִ��� ���� �����ִ� ��

public class userTest {
	@Autowired
	private UserMapper userMapper;
	
	/*
	@Test
	public void testSignUp() throws Exception{
		UserVO user = new UserVO();
		user.setUserid("aaa1");
		user.setUserpw("111");
		user.setUsername("�׸���");
		user.setEmail("aaa1@naver.com");
		user.setGender('��');
		user.setNickname("�������");
		user.setAddr1("�����");
		user.setAddr2("��鱸");
		user.setAddr3("�ູ��");
		
		userMapper.signUp(user);
	}
	*/
	
	@Test
	public void testLog() throws Exception{
		UserVO user = new UserVO();
		user.setUserid("aaa1");
		user.setUserpw("111");
		
		UserVO result = userMapper.login(user);
		System.out.println("��� : "+result.toString());
		
	}
	

}

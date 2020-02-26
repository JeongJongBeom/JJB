package com.jjb.service;

import com.jjb.model.UserVO;

public interface UserService {
	public UserVO login(UserVO user) throws Exception;
	
	public void signUp(UserVO user) throws Exception;
	
	public String checkID(String userid) throws Exception;
	
	public String checkNick(String nickname) throws Exception;
	
	public String checkPW(String userid) throws Exception;
	
	//�г��� �������� ã�� ����
	public UserVO InfoFromId(String userid) throws Exception;
	
	//�г���, �̸���, �ּ� ����
	public void changeInfo(UserVO user) throws Exception;
	
	//��й�ȣ ����
	public void changePw(String newPw, String userid) throws Exception;
	
	//���� Ż��
	public void deleteUser(String userid) throws Exception;
}

package com.jjb.mapper;

import java.util.List;

import com.jjb.model.Criteria;
import com.jjb.model.UserVO;

public interface UserMapper {
	//�α���
	public UserVO login(UserVO user) throws Exception;
	
	//ȸ������
	public void signUp(UserVO user) throws Exception;
	
	//���̵� Ȯ��
	public String checkID(String userid) throws Exception;
	
	//�г��� Ȯ��
	public String checkNick(String nickname) throws Exception;
	
	//��й�ȣ Ȯ��
	public String checkPW(String userid) throws Exception;
	
	//���̵� �������� ã�� ����
	public UserVO InfoFromId(String userid) throws Exception;
	
	//������_���� ����
	public void changeChefInfo(UserVO user) throws Exception;
	
	//������, �г���, �̸���, �ּ� ����
	public void changeInfo(UserVO user) throws Exception;
	
	//��к�ȣ ����
	public void changePw(String newPw, String userid) throws Exception;
	
	//���� Ż��
	public void deleteUser(String userid) throws Exception;

	//���� ����Ʈ
	public List<UserVO> userList(Criteria cri) throws Exception;
	
	//���� ī��Ʈ
	public int userCount() throws Exception;
	
	//���� ���� �ο�
	public void grantUser(UserVO user) throws Exception;
	
	//���� ����Ʈ�� �߰�
	public void insertChef(UserVO user) throws Exception;
	
	//���� ���� ����
	public void revokeUser(UserVO user) throws Exception;
	
	//���� ����Ʈ���� ����
	public void deleteChef(UserVO user) throws Exception;
}

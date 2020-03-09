package com.jjb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjb.mapper.UserMapper;
import com.jjb.model.Criteria;
import com.jjb.model.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper um;
	
	//�α���
	@Override
	public UserVO login(UserVO user) throws Exception {
		return um.login(user);
	}
	
	//ȸ������
	@Override
	public void signUp(UserVO user) throws Exception {
		um.signUp(user);
	}
	
	//���̵� Ȯ��
	@Override
	public String checkID(String userid) throws Exception {
		return um.checkID(userid);
	}

	//��й�ȣ Ȯ��
	@Override
	public String checkPW(String userid) throws Exception {
		return um.checkPW(userid);
	}

	//�г��� Ȯ��
	@Override
	public String checkNick(String nickname) throws Exception {
		return um.checkNick(nickname);
	}

	//���̵� �������� ã�� ����
	@Override
	public UserVO InfoFromId(String userid) throws Exception {
		return um.InfoFromId(userid);
	}
	
	//������, �г���, �̸���, �ּ� ����
	@Override
	public void changeInfo(UserVO user) throws Exception {
		um.changeInfo(user);
	}
	
	//������_���� ����
	@Transactional
	@Override
	public void changeChefInfo(UserVO user) throws Exception {
		um.changeInfo(user);
		um.changeChefInfo(user);
	}
	
	//��к�ȣ ����
	@Override
	public void changePw(String newPw, String userid) throws Exception {
		um.changePw(newPw, userid);

	}
	
	//���� Ż��
	@Override
	public void deleteUser(String userid) throws Exception {
		um.deleteUser(userid);
	}
	
	//���� ����Ʈ
	@Override
	public List<UserVO> userList(Criteria cri) throws Exception {
		return um.userList(cri);
	}
	
	//���� ���� �ο�
	@Transactional
	@Override
	public void grantUser(UserVO user) throws Exception {
		um.grantUser(user);
		um.insertChef(user);
	}

	//���� ���� ����
	@Transactional
	@Override
	public void revokeUser(UserVO user) throws Exception {
		um.revokeUser(user);
		um.deleteChef(user);
	}

	//���� ī��Ʈ
	@Override
	public int userCount() throws Exception {
		return um.userCount();
	}
}

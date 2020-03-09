package com.jjb.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jjb.model.Criteria;
import com.jjb.model.UserVO;

@Repository
public class UserMapperImpl implements UserMapper{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace="com.jjb.mapper.UserMapper";

	//�α���
	@Override
	public UserVO login(UserVO userVO) throws Exception {
		UserVO user= sqlSession.selectOne(namespace+".login",userVO);
		return user;
	}
	
	//ȸ������
	@Override
	public void signUp(UserVO user) throws Exception {
		sqlSession.insert(namespace+".signUp", user);		
	}

	//���̵� Ȯ��
	@Override
	public String checkID(String userid) throws Exception {
		String checkedid = sqlSession.selectOne(namespace+".checkID",userid);
		return checkedid;
	}

	//�г��� Ȯ��
	@Override
	public String checkNick(String nickname) throws Exception {
		String checkednick = sqlSession.selectOne(namespace+".checkNick",nickname);
		return checkednick;
	}

	//��й�ȣ Ȯ��
	@Override
	public String checkPW(String userid) throws Exception {
		String PwForCk = sqlSession.selectOne(namespace+".checkPW",userid);
		return PwForCk;
	}

	//���̵� ������ ã�� ����
	@Override
	public UserVO InfoFromId(String userid) throws Exception {
		UserVO user = sqlSession.selectOne(namespace+".InfoFromId",userid); 
		return user;
	}

	//������, �г���, �̸���, �ּ� ����
	@Override
	public void changeInfo(UserVO user) throws Exception {
		sqlSession.update(namespace+".changeInfo",user);
	}
	
	//������_���� ����
	@Override
	public void changeChefInfo(UserVO user) throws Exception {
		sqlSession.update(namespace+".changeChefInfo",user);
	}

	//��й�ȣ ����
	@Override
	public void changePw(String newPw, String userid) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("newPw", newPw);
		paramMap.put("userid", userid);
		sqlSession.update(namespace+".changePw",paramMap);
		
	}

	//���� Ż��
	@Override
	public void deleteUser(String userid) throws Exception {
		sqlSession.delete(namespace+".deleteUser",userid);
	}
	
	//���� ����Ʈ
	@Override
	public List<UserVO> userList(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".userList",cri);
		return list;
	}
	
	//���� ���� �ο�
	@Override
	public void grantUser(UserVO user) throws Exception {
		sqlSession.update(namespace+".grantUser",user);
	}
	
	//���� ����Ʈ�� �߰�
	@Override
	public void insertChef(UserVO user) throws Exception {
		sqlSession.insert(namespace+".insertChef",user);
	}
	
	//���� ���� ����
	@Override
	public void revokeUser(UserVO user) throws Exception {
		sqlSession.update(namespace+".revokeUser",user);
	}
	
	//���� ����Ʈ���� ����
	@Override
	public void deleteChef(UserVO user) throws Exception {
		sqlSession.delete(namespace+".deleteChef",user);
	}

	//���� ī��Ʈ
	@Override
	public int userCount() throws Exception {
		return sqlSession.selectOne(namespace+".UserCount");
	}
}

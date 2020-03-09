package com.jjb.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jjb.model.ChefVO;

@Repository
public class ChefMapperImpl implements ChefMapper{
	
	@Autowired
	private SqlSession sqlSession;	
	private static final String namespace="com.jjb.mapper.ChefMapper";
	
	//���� ����Ʈ
	@Override
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".cheflist",paramMap);
		return list;
	}

	//���� ����¡
	@Override
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception {
		List<ChefVO> list = sqlSession.selectList(namespace+".chefListPaging", paramMap);
		return list;
	}
	
	//���� ī����
	@Override
	public int ChefCount() throws Exception {
		int total = sqlSession.selectOne(namespace+".chefCount");
		return total;
	}
	
	//�ȷο�
	@Override
	public void follow(Map<String, Object> follow) throws Exception {
		sqlSession.insert(namespace+".follow", follow);
	}
	
	//�ȷο� ���
	@Override
	public void unfollow(Map<String, Object> follow) throws Exception {
		sqlSession.delete(namespace+".unfollow", follow);
		
	}
	
	//�ȷο� �� ���
	@Override
	public void follownum(Map<String, Object> follow) throws Exception {
		System.out.println(follow);
		sqlSession.update(namespace+".follownum", follow);
	}

}

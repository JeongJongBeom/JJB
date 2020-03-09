package com.jjb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjb.mapper.ChefMapper;
import com.jjb.model.ChefVO;

@Service
public class ChefServiceImpl implements ChefService{
	@Autowired
	private ChefMapper cm;
	
	//���� ����Ʈ
	@Override
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception {
		return cm.ChefList(paramMap);
	}
	
	//���� ����Ʈ ����¡
	@Override
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception {
		return cm.ChefListPaging(paramMap);
	}

	//���� ī��Ʈ
	@Override
	public int ChefCount() throws Exception {
		return cm.ChefCount();
	}
	
	//�ȷο�+�ȷο� �� ���
	@Transactional
	@Override
	public void follow(Map<String, Object> follow) throws Exception {
		cm.follow(follow);
		cm.follownum(follow);
	}
	
	//�ȷο� ���+�ȷο� �� ���
	@Transactional
	@Override
	public void unfollow(Map<String, Object> follow) throws Exception {
		cm.unfollow(follow);
		cm.follownum(follow);
	}
}

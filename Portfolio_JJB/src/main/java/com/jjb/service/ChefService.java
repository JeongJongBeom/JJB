package com.jjb.service;

import java.util.List;
import java.util.Map;

import com.jjb.model.ChefVO;

public interface ChefService {
	//���� ����Ʈ
	public List<ChefVO> ChefList(Map<String, Object> paramMap) throws Exception;
	
	//���� ����¡
	public List<ChefVO> ChefListPaging(Map<String, Object> paramMap) throws Exception; 
	
	//���� ī����
	public int ChefCount() throws Exception;
	
	// �ȷο�
	public void follow(Map<String, Object> follow) throws Exception;

	// �ȷο� ���
	public void unfollow(Map<String, Object> follow) throws Exception;
}

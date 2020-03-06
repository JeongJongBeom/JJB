package com.jjb.mapper;

import java.util.List;
import java.util.Map;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.RepBoardVO;

public interface BoardMapper {
	// �Խ��� ����Ʈ
	public List<BoardVO> boardlist(String name) throws Exception;

	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception;

	// ��ü ������ ����
	public int boardCount(Map<String, Object> paramMap) throws Exception;

	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception;

	public void boardWrite(Map<String, Object> paramMap) throws Exception;

	public void boardModify(Map<String, Object> paramMap) throws Exception;

	public void boardDelete(Map<String, Object> paramMap) throws Exception;

	// �Խ��� ��� ��ȸ
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception;

	// ��� ���� ��ȸ
	public int RepCount(Map<String, Object> paramMap) throws Exception;

	// ��� �ۼ�
	public void repWrite(Map<String, Object> paramMap) throws Exception;

	// ��� ����
	public void repModify(Map<String, Object> paramMap) throws Exception;

	// ��� ����
	public void repDelete(Map<String, Object> paramMap) throws Exception;

	// �Խ��� ���������� ����Ʈ
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception;

	// ��ȸ�� ���
	public void addViewCnt(Map<String, Object> paramMap) throws Exception;

	// ���ƿ� ��ȸ
	public int likeck(Map<String, Object> likeck) throws Exception;

	// ���ƿ�
	public void like(Map<String, Object> like) throws Exception;

	// ���ƿ� ���
	public void unlike(Map<String, Object> like) throws Exception;

	// �ȷο� ��ȸ
	public int followck(Map<String, Object> followck) throws Exception;

	// Ű���� �˻�
	public void searchKeyword(Map<String, Object> search) throws Exception;

	// �ֱ� �˻� Ű����
	public List<String> RecentKeyword() throws Exception;
	
	// ������ ��ȸ��, �ֽż�
	public List<BoardVO> orderRecipe(int order) throws Exception; 
	
	// ������ ���ƿ��
	public List<BoardVO> orderRecipe_like() throws Exception;
	
	// ������ ���ƿ�� paging
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception;
	
	// �Խ��� ���ۼ�_�⺻
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception;
	
	//�Խ��� ����_�⺻
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception;
	
	// ������ �亯 ���� �� �ۼ�
	public void help_answer(BoardVO board) throws Exception;
}

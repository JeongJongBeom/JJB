package com.jjb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjb.mapper.BoardMapper;
import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.RepBoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper bm;
	
	// �Խ��� ����Ʈ
	@Override
	public List<BoardVO> boardlist(String name) throws Exception {
		return bm.boardlist(name);
	}
	
	// �Խ��� ����Ʈ ����¡ ó��
	@Override
	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception {
		return bm.boardListPaging(paramMap);
	}
	
	// ��ü ������ ����
	@Override
	public int boardCount(Map<String, Object> paramMap) throws Exception {
		return bm.boardCount(paramMap);
	}
	
	//boardDetailList
	@Override
	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception {
		return bm.boardDetail(paramMap);
	}
	
	// �Խ��� ��� ��ȸ
	@Override
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception {
		return bm.repBoardList(paramMap);
	}
	
	// ��� ���� ��ȸ
	@Override
	public int RepCount(Map<String, Object> paramMap) throws Exception {
		return bm.RepCount(paramMap);
	}
	
	// ��� �ۼ�
	@Override
	public void repWrite(Map<String, Object> paramMap) throws Exception {
		bm.repWrite(paramMap);
	}
	
	// ��� ����
	@Override
	public void repModify(Map<String, Object> paramMap) throws Exception {
		bm.repModify(paramMap);
	}
	
	// ��� ����
	@Override
	public void repDelete(Map<String, Object> paramMap) throws Exception {
		bm.repDelete(paramMap);
		
	}
	
	//�Խ��� �۾���
	@Override
	public void boardWrite(Map<String, Object> paramMap) throws Exception {
		bm.boardWrite(paramMap);
	}
	
	//�Խ��� �ۼ���
	@Override
	public void boardModify(Map<String, Object> paramMap) throws Exception {
		bm.boardModify(paramMap);
	}
	
	//�Խ��� �ۻ���
	@Override
	public void boardDelete(Map<String, Object> paramMap) throws Exception {
		bm.boardDelete(paramMap);
	}
	
	// �Խ��� ���������� ����Ʈ
	@Override
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception {
		return bm.ModifyList(paramMap);
	}
	
	// ��ȸ�� ���
	@Override
	public void addViewCnt(Map<String, Object> paramMap) throws Exception {
		bm.addViewCnt(paramMap);
	}
	
	// ���ƿ� ��ȸ
	@Override
	public int likeck(Map<String, Object> likeck) throws Exception {
		return bm.likeck(likeck);
	}
	
	// ���ƿ�
	@Override
	public void like(Map<String, Object> like) throws Exception {
		bm.like(like);
	}
	
	// ���ƿ� ���
	@Override
	public void unlike(Map<String, Object> like) throws Exception {
		bm.unlike(like);
	}
	
	// �ȷο� ��ȸ
	@Override
	public int followck(Map<String, Object> followck) throws Exception {
		return bm.followck(followck);
	}
	
	// Ű���� �˻�
	@Override
	public void searchKeyword(Map<String, Object> search) throws Exception {
		bm.searchKeyword(search);
	}
	
	// �ֱ� �˻� Ű����
	@Override
	public List<String> RecentKeyword() throws Exception {
		return bm.RecentKeyword();
	}
	
	// ������ ��ȸ��, �ֽż�
	@Override
	public List<BoardVO> orderRecipe(int order) throws Exception {
		return bm.orderRecipe(order);
	}
	
	// ������ ���ƿ��
	@Override
	public List<BoardVO> orderRecipe_like() throws Exception {
		return bm.orderRecipe_like();
	}
	
	// ������ ���ƿ�� paging
	@Override
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception {
		return bm.likePaging(paramMap);
	}
	
	// �Խ��� ���ۼ�_�⺻
	@Override
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception {
		bm.boardWriteBasic(paramMap);
	}
	
	//�Խ��� ����_�⺻
	@Override
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception {
		bm.boardModifyBasic(paramMap);;
	}
	
	// ������ �亯 ���� �� �ۼ�
	@Override
	public void help_answer(BoardVO board) throws Exception {
		bm.help_answer(board);
	}
}

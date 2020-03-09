package com.jjb.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jjb.model.BoardVO;
import com.jjb.model.Criteria;
import com.jjb.model.RepBoardVO;

@Repository
public class BoardMapperImpl implements BoardMapper{

	@Inject //Autowired�� ����
	private SqlSession sqlSession;	
	private static final String namespace="com.jjb.mapper.BoardMapper";
	
	// �Խ��� ����Ʈ
	@Override
	public List<BoardVO> boardlist(String name) throws Exception {
		List list = sqlSession.selectList(namespace+".boardlist", name);
		return list;
	}
	
	// �Խ��� ����Ʈ ����¡ ó��
	@Override
	public List<BoardVO> boardListPaging(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPage",paramMap);
		return list;
	}
	
	// ��ü ������ ����
	@Override
	public int boardCount(Map<String, Object> paramMap) throws Exception {
		int count = sqlSession.selectOne(namespace+".boardCount",paramMap);
		return count;
	}
	
	//boardDetailList
	@Override
	public BoardVO boardDetail(Map<String, Object> paramMap) throws Exception {
		BoardVO detail = sqlSession.selectOne(namespace+".boardDetail",paramMap);
		return detail;
	}
	
	// �Խ��� ��� ��ȸ
	@Override
	public List<RepBoardVO> repBoardList(Map<String, Object> paramMap) throws Exception {
		List list = sqlSession.selectList(namespace+".repBoardListPage",paramMap);
		return list;
	}
	
	// ��� ���� ��ȸ
	@Override
	public int RepCount(Map<String, Object> paramMap) throws Exception {
		int total = sqlSession.selectOne(namespace+".RepCount",paramMap);
		return total;
	}
	
	// ��� �ۼ�
	@Override
	public void repWrite(Map<String, Object> paramMap) throws Exception {
		sqlSession.insert(namespace+".repWrite", paramMap);
	}
	
	// ��� ����
	@Override
	public void repModify(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".repModify", paramMap);
	}
	
	// ��� ����
	@Override
	public void repDelete(Map<String, Object> paramMap) throws Exception {
		sqlSession.delete(namespace+".repDelete",paramMap);
	}
	
	//�Խ��� �۾���
	@Override
	public void boardWrite(Map<String, Object> paramMap) throws Exception {
		sqlSession.insert(namespace+".boardWrite", paramMap);
		
	}
	
	//�Խ��� �ۼ���
	@Override
	public void boardModify(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".boardModify", paramMap);
	}
	
	//�Խ��� �ۻ���
	@Override
	public void boardDelete(Map<String, Object> paramMap) throws Exception {
		sqlSession.delete(namespace+".boardDelete", paramMap);
	}
	
	// �Խ��� ���������� ����Ʈ
	@Override
	public BoardVO ModifyList(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectOne(namespace+".ModifyList",paramMap);
		
	}
	
	// ��ȸ�� ���
	@Override
	public void addViewCnt(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".addViewCnt", paramMap);
	}
	
	// ���ƿ� ��ȸ
	@Override
	public int likeck(Map<String, Object> likeck) throws Exception {
		return sqlSession.selectOne(namespace+".likeck", likeck);
	}
	
	// ���ƿ�
	@Override
	public void like(Map<String, Object> like) throws Exception {
		sqlSession.insert(namespace+".like", like);
		
	}
	
	// ���ƿ� ���
	@Override
	public void unlike(Map<String, Object> like) throws Exception {
		sqlSession.delete(namespace+".unlike",like);
	}
	
	// �ȷο� ��ȸ
	@Override
	public int followck(Map<String, Object> followck) throws Exception {
		return sqlSession.selectOne(namespace+".followck", followck);
	}
	
	// Ű���� �˻�
	@Override
	public void searchKeyword(Map<String, Object> search) throws Exception {
		sqlSession.insert(namespace+".searchKeyword",search);
	}
	
	// �ֱ� �˻� Ű����
	@Override
	public List<String> RecentKeyword() throws Exception {
		return sqlSession.selectList(namespace+".RecentKeyword");
	}
	
	// ������ ��ȸ��, �ֽż�
	@Override
	public List<BoardVO> orderRecipe(int order) throws Exception {
		return sqlSession.selectList(namespace+".orderRecipe", order);
	}
	
	// ������ ���ƿ��
	@Override
	public List<BoardVO> orderRecipe_like() throws Exception {
		return sqlSession.selectList(namespace+".orderRecipe_like");
	}
	
	// ������ ���ƿ�� paging
	@Override
	public List<BoardVO> likePaging(Map<String, Object> paramMap) throws Exception {
		return sqlSession.selectList(namespace+".likePaging",paramMap);
	}
	
	// �Խ��� ���ۼ�_�⺻
	@Override
	public void boardWriteBasic(Map<String, Object> paramMap) throws Exception {
		sqlSession.insert(namespace+".boardWriteBasic",paramMap);
	}
	
	//�Խ��� ����_�⺻
	@Override
	public void boardModifyBasic(Map<String, Object> paramMap) throws Exception {
		sqlSession.update(namespace+".boardModifyBasic",paramMap);
	}
	
	// ������ �亯 ���� �� �ۼ�
	@Override
	public void help_answer(BoardVO board) throws Exception {
		sqlSession.update(namespace+".help_answer",board);
	}
}

package com.jjb.Controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jjb.mapper.BoardMapper;
import com.jjb.model.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)//������ �Ҷ� SpringJUnit4ClassRunner Ŭ������ ���� ������ 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//context�� ����ִ��� ���� �����ִ� ��
public class BoardTest {
	@Autowired
	private BoardMapper bm;
	
	@Test
	public void testSelect() throws Exception{
		String name = "tbl_board_notice";
		List<BoardVO> board = bm.boardlist(name);
		System.out.println(board);
	}

}

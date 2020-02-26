package com.jjb.Controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)//������ �Ҷ� SpringJUnit4ClassRunner Ŭ������ ���� ������ 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//context�� ����ִ��� ���� �����ִ� ��

public class ConnectPoolTest {
	@Autowired//DataSource dataSource = new DataSource(); ����
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Test//junit test�� ���� �����ϱ� ���ؼ� �ٿ��ִ� ��
	public void testConnection() {
		try (
				SqlSession session = sqlSessionFactory.openSession();
				Connection con = dataSource.getConnection();
				){
			System.out.println("����="+session);
			System.out.println("Ŀ��="+con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

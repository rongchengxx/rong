package test.single_page;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.SinglePageDao;
import com.rcb.entity.SinglePage;

public class TestSinglePageDao {
	SinglePageDao dao = null;
	
	@Before
	public void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		dao = context.getBean("singlePageDao",SinglePageDao.class);
	}
	
	@Test	//findSinglePageAll
	public void test1(){
		
		List<SinglePage> singlePages = dao.findSinglePageAll();
		System.out.println(singlePages);
		
	}
	
	@Test	//addSinglePage
	public void test2(){
		
		SinglePage singlePage = new SinglePage("003", "0000", "0000", "title", null, null, "asd", null, null, null, null, 0, null, null, null, 0, 0);
		int rows = dao.addSinglePage(singlePage);
		System.out.println(rows);
		
	}
	
	@Test	//findSinglePageById
	public void test3(){
		
		SinglePage singlePage = dao.findSinglePageById("001");
		System.out.println(singlePage);
		
	}
	
	
	@Test	//modifySinglePage
	public void test4(){
		
		SinglePage singlePage = dao.findSinglePageById("002");
		singlePage.setTitle("asgsad");
		int rows = dao.modifySinglePage(singlePage);
		System.out.println(rows);
		
	}
	
	@Test	//deleteSinglePageById
	public void test5(){
		
		int rows = dao.delSinglePageById("002");
		System.out.println(rows);
		
	}
	
	@Test	//findSinglePageByPage
	public void test6(){
		
		List<SinglePage> list = dao.findSinglePageByPage(0);
		System.out.println(list);
		
	}
}
















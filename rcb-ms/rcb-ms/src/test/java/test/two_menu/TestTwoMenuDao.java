package test.two_menu;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.TwoMenuDao;
import com.rcb.entity.TwoMenu;

public class TestTwoMenuDao {
	TwoMenuDao dao = null;
	
	@Before
	public void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		dao = context.getBean("twoMenuDao",TwoMenuDao.class);
	}
	
	@Test	//findTwoMenuAll
	public void test1(){
		
		List<TwoMenu> twoMenus = dao.findTwoMenuAll();
		System.out.println(twoMenus);
		
	}
	
	@Test	//addTwoMenu
	public void test2(){
		
		TwoMenu twoMenu = new TwoMenu("id"+Math.random(),"12", "title", "thumb", "content", 5, 1, "intro");
		dao.addTwoMenu(twoMenu);
		
	}
	
	@Test	//findTwoMenuById
	public void test3(){

		TwoMenu twoMenu = dao.findTwoMenuById("14");
		System.out.println(twoMenu);
		
	}
	
	
	@Test	//modifyTwoMenu
	public void test4(){
		
		TwoMenu twoMenu = dao.findTwoMenuById("12");
		twoMenu.setTitle("aka");
		dao.modifyTwoMenu(twoMenu);
		System.out.println(twoMenu);
		
	}
	
	@Test	//deleteTwoMenuById
	public void test5(){
		
		dao.delTwoMenuById("12");
		
	}
	
}
















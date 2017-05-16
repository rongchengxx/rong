package test.one_menu;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.OneMenuDao;
import com.rcb.entity.OneMenu;

public class TestOneMenuDao {
	OneMenuDao dao = null;
	
	@Before
	public void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		dao = context.getBean("oneMenuDao",OneMenuDao.class);
	}
	
	@Test	//findOneMenuAll
	public void test1(){
		
		List<OneMenu> oneMenus = dao.findOneMenuAll();
		System.out.println(oneMenus);
		
	}
	
	@Test	//addOneMenu
	public void test2(){
		
		OneMenu oneMenu = new OneMenu("id"+Math.random(), "title", "thumb", "content", 5, 1, "intro");
		dao.addOneMenu(oneMenu);
		
	}
	
	@Test	//findOneMenuById
	public void test3(){
		
		OneMenu oneMenu = dao.findOneMenuById("11");
		System.out.println(oneMenu);
		
	}
	
	
	@Test	//modifyOneMenu
	public void test4(){
		
		OneMenu oneMenu = dao.findOneMenuById("11");
		oneMenu.setTitle("asgsad");
		dao.modifyOneMenu(oneMenu);
		System.out.println(oneMenu);
		
	}
	
	@Test	//deleteOneMenuById
	public void test5(){
		
		dao.delOneMenuById("asdas654");
		
	}
}
















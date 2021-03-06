package test.two_menu;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rcb.entity.TwoMenu;
import com.rcb.service.two_menu.TwoMenuService;

import com.rcb.utils.CreateUUID;

import test.TestBase;

public class TestTwoMenuService 
					extends TestBase{
	private TwoMenuService twoMenuService;
	@Before
	public void init(){
		twoMenuService = super.getContext().getBean(
				"twoMenuService", TwoMenuService.class);
	}
	@Test	//findTwoMenuAll
	public void test1(){
		
		List<TwoMenu> list = twoMenuService.findTwoMenuAll();
		System.out.println(list);
	}
	@Test 	//addTwoMenu
	public void test2(){
		TwoMenu row = twoMenuService.addTwoMenu("65", "a", "a", "a", 1, 1,"asd");
		System.out.println(row);
	}
	
	@Test 	//modifyTwoMenu
	public void test3(){
		int row = twoMenuService.modifyTwoMenu("2", "xiugai", "xiugai", "xiugai", "xiugai", 1, 1,"asd");
		System.out.println(row);
	}
	
	@Test 	//delTwoMenuById
	public void test4(){
		int row = twoMenuService.delTwoMenuById("a");
		System.out.println(row);
	}
	
	@Test	//findTwoMenuById
	public void test5(){
		TwoMenu twoMenu = twoMenuService.findTwoMenuById("2");
		System.out.println(twoMenu);
	}
	
	@Test	//findTwoMenuByOneMenuId
	public void test6(){
		List<TwoMenu> list = twoMenuService.findTwoMenuByOneMenuId("5eeac4cb-e7cf-4adb-97f7-69352fe05107");
		System.out.println(list);
	}
}











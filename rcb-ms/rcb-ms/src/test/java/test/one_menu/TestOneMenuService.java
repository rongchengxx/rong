package test.one_menu;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rcb.entity.OneMenu;
import com.rcb.service.one_menu.OneMenuService;
import com.rcb.utils.CreateUUID;

import test.TestBase;

public class TestOneMenuService 
					extends TestBase{
	private OneMenuService oneMenuService;
	@Before
	public void init(){
		oneMenuService = super.getContext().getBean(
				"oneMenuService", OneMenuService.class);
	}
	@Test	//findOneMenuAll
	public void test1(){
		
		List<OneMenu> list = oneMenuService.findOneMenuAll();
		System.out.println(list);
	}
	@Test 	//addOneMenu
	public void test2(){
		OneMenu row = oneMenuService.addOneMenu("asd", "asd", "asd", 5, 1,"asd");
		System.out.println(row);
	}
	
	@Test 	//modifyOneMenu
	public void test3(){
		int row = oneMenuService.modifyOneMenu("123", "f", "f", "ff", 2, 1,"asd");
		System.out.println(row);
	}
	
	@Test 	//delOneMenuById
	public void test4(){
		int row = oneMenuService.delOneMenuById("11");
		System.out.println(row);
	}
	
}











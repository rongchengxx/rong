package test.one_menu;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rcb.entity.OneMenu;
import com.rcb.service.one_menu.OneMenuService;

import test.TestBase;

public class TestOneMenuService 
					extends TestBase{
	private OneMenuService oneMenuService;
	@Before
	public void init(){
		oneMenuService = super.getContext().getBean(
				"oneMenuService", OneMenuService.class);
	}
	@Test
	public void test1(){
		List<OneMenu> list = oneMenuService.findOneMenuAll();
		
		
		System.out.println(list);
	}
	
}











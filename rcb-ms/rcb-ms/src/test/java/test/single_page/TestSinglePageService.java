package test.single_page;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rcb.entity.SinglePage;
import com.rcb.service.single_page.SinglePageService;


import test.TestBase;

public class TestSinglePageService 
					extends TestBase{
	private SinglePageService service;
	@Before
	public void init(){
		service = super.getContext().getBean(
				"singlePageService", SinglePageService.class);
	}
	@Test 	//findSinglePageByPage
	public void test1(){
		List<SinglePage> list = service.findSinglePageByPage(0);
		System.out.println(list);
	}
	@Test	//addSinglePage
	public void test2() {
		SinglePage singlePage = service.addSinglePage("003", "003", "003", "003", "003", "003", "003", "003", "003", null, 1, "003", 1, 1);
		System.out.println(singlePage);
	}
	@Test	//modifySinglePage
	public void test3() {
		int row = service.modifySinglePage("003", "003", "003", "003", "003", "003", "003", "003", "003", "003", null, 1, "003", 1, 1);
		System.out.println(row);
	}
	@Test	//delSinglePageById
	public void test4() {
		int row = service.delSinglePageById("1");
		System.out.println(row);
	}
}











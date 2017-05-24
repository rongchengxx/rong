package test.gbook;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.entity.Gbook;
import com.rcb.service.gbook.GbookService;


public class TestGbookServie {
	private GbookService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("gbookService",
				GbookService.class);
	}
	@Test 
	public void test1(){
		int n=service.delGbookById("2");
		System.out.println(n);
	}
	@Test 
	public void test2(){
		int m=service.delGbooksById("a","b");
		System.out.println(m);
	}
	@Test 
	public void test3(){
		List<Gbook> list=service.findGbookByPage(0);
		System.out.println(list);
	}
}

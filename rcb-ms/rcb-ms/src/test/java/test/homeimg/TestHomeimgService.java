package test.homeimg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.HomeImgDao;
import com.rcb.entity.HomeImg;
import com.rcb.service.home_img.HomeImgService;



public class TestHomeimgService {
	private HomeImgService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("homeImgService",
				HomeImgService.class);
	}
	@Test 
	public void test1(){
		HomeImg hig=service.findHomeImgById("2");
		System.out.println(hig);
	}
	@Test 
	public void test2(){
		List<HomeImg> list=service.findHomeImgAll();
		System.out.println(list);
	}
	@Test 
	public void test3(){
		HomeImg hig = new HomeImg("33", "127.0.0.1", "标题", 1, 5, "今天天气不错", "www.123.com", 2, 1);
		service.addHomeImg(hig);
	}
	@Test 
	public void test4(){
		int n=service.delHomeImgById("33");
		System.out.println(n);
	}
	@Test 
	public void test5(){
		HomeImg hig = new HomeImg("33", "127.0.0.1", "123", 1, 5, "今天天气不错", "www.123.com", 2, 1);
		int m=service.modifyHomeImg(hig);
		System.out.println(m);
	}
	
}

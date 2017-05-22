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
		HomeImg hig=service.findHomeImgById("1");
		System.out.println(hig);
	}
	@Test 
	public void test2(){
		List<HomeImg> list=service.findHomeImgAll();
		System.out.println(list);
	}
	@Test 
	public void test3(){
//		HomeImg hig = new HomeImg();
		service.addHomeImg("9","北京", "欢迎 ", "ni", "人民", 1);
//		System.out.println(h1);
		}
	@Test 
	public void test4(){
		service.delHomeImgById("1");
		
	}
	@Test 
	public void test5(){
//		HomeImg hig =service.findHomeImgById("三");
//		hig.setUrl("11.11.11.22");
		int row=service.modifyHomeImg("1","墨染2", "d", "afs", "sdf", 2);
		System.out.println(row);
	}
	
}

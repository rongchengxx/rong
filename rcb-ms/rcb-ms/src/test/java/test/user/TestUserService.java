package test.user;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.entity.User;
import com.rcb.service.user.UserService;


public class TestUserService {
	private UserService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("userService",
				UserService.class);
	}
	@Test 
	public void test1(){
		User user=service.login("caocao", "123");
		System.out.println(user);
	}
	@Test 
	public void test2(){
		User user=service.modifyUser("1", "123", "234");
		System.out.println(user);
	}
	
}









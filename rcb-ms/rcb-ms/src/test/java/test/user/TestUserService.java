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
				"conf/spring-mybatis.xml",
				"conf/spring-transaction.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("userService",
				UserService.class);
	}
	@Test //用例-1: 预期结果:用户名错误
	public void test1(){
		//User user=service.login("zhang", "123456");
		System.out.println(
				service.getClass().getName());
	}
	
	@Test //用例-2: 预期结果:密码错误
	public void test2(){
		User user=service.login("demo", "123");
	}
	@Test //用例-3  预期结果:登录成功
	public void test3(){
		User user=service.login("caocao", 
		"123");
		System.out.println(user);
	}
}









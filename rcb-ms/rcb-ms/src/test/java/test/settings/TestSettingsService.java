package test.settings;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.entity.Settings;
import com.rcb.service.settings.SettingsService;


public class TestSettingsService{
	private SettingsService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("settingsService",
				SettingsService.class);
	}
	@Test 
	public void test1(){
		Settings sett1 = new Settings("1111a", "中文t", "127.0.0.1", "io55", "长方", "孙膑", 65655, 7777777, 556565, 1234567, "123@qq.com", "北京", "我是内容，风景不错");
		int n=service.addSettings(sett1);
		System.out.println(n);
	}
	@Test 
	public void test2(){
		Settings sett=service.findSettingsById("进");
		System.out.println(sett);
	}
}

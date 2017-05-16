package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class TestBase {
	public ApplicationContext getContext(){
		String[] conf={
				"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext ac
			= new ClassPathXmlApplicationContext(conf);
		return ac;
	}
}






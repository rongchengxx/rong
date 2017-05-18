package test.user;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.UserDao;
import com.rcb.entity.User;

public class TestUserDao {
	@Test
	public void testFindByName(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		User user=dao.findByName("caocao");
		System.out.println(user);
	}

	@Test
	public void testModifyUserPwd(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
				context.getBean("userDao",UserDao.class);
		User user = dao.findByName("caocao");
		user.setPassword("中2");
		dao.modifyUser(user);
		System.out.println(user);
	}

	@Test
	public void testFindById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		UserDao dao=
		context.getBean("userDao",UserDao.class);
		User user=dao.findById("1");
		System.out.println(user);
	}
}
















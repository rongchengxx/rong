package test.gbook;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.GbookDao;
import com.rcb.entity.Gbook;

public class TestGbookDao {
	@Test
	public void delHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		GbookDao dao=
		context.getBean("gbookDao",GbookDao.class);
		dao.delGbookById("是否a");
	}
	
	@Test
	public void findGbookByPage(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		GbookDao dao=
		context.getBean("gbookDao",GbookDao.class);
		List<Gbook> list=dao.findGbookByPage(0);
		System.out.println(list);
		
	}
}

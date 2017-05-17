package test.homeimg;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.HomeImgDao;
import com.rcb.entity.HomeImg;


public class TestHomeimgDao {
	@Test
	public void findHomeImgById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		HomeImg hig=dao.findHomeImgById("4566");
		System.out.println(hig);
	}
	@Test
	public void addHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		HomeImg hig = new HomeImg("23", "127.0.0.1", "标题", 1, 5, "今天天气不错", "www.123.com", 2, 1);
		dao.addHomeImg(hig);
		
		
	}
	@Test
	public void delHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		dao.delHomeImgById("4566");
	}
	
	@Test
	public void modifyHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		HomeImg hig=dao.findHomeImgById("1");
		hig.setTitle("盖");
		dao.modifyHomeImg(hig);
	}
	@Test
	public void findHomeImgAll(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		List<HomeImg> hig=dao.findHomeImgAll();
		System.out.println(hig);
	}
	
}

package test.homeimg;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.HomeImgDao;
import com.rcb.entity.HomeImg;
import com.rcb.utils.NoteUtil;


public class TestHomeimgDao {
	@Test
	public void findHomeImgById(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		HomeImg hig=dao.findHomeImgById("1");
		System.out.println(hig);
	}
	@Test
	public void addHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		HomeImg hig = new HomeImg();
		hig.setId("123");
		hig.setTitle("南开2");
		hig.setUrl("和平");
		hig.setLink("黑屏");
		hig.setContent("和平");
		hig.setSeq(3);
		dao.addHomeImg(hig);
		
		
	}
	@Test
	public void delHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		dao.delHomeImgById("123");
	}
	
	@Test
	public void modifyHomeimg(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		HomeImgDao dao=
		context.getBean("homeImgDao",HomeImgDao.class);
		HomeImg hig=dao.findHomeImgById("1");
		hig.setTitle("山合适");
		int n=dao.modifyHomeImg(hig);
		System.out.println(n);
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
	@Test
	public void test(){
		System.out.println(NoteUtil.createId());
		System.out.println(NoteUtil.md5("1"));
	}
}

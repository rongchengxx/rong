package test.settings;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.SettingsDao;
import com.rcb.entity.Settings;

public class TestSettingsDao {
	@Test
	public void findbyid(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		SettingsDao dao=
		context.getBean("settingsDao",SettingsDao.class);
		Settings sett=dao.findSettingsById("进");
		System.out.println(sett);
	}
	
@Test
public void addSettings(){
	ApplicationContext context=
			new ClassPathXmlApplicationContext(
					"conf/spring-mybatis.xml");
	SettingsDao dao=
	context.getBean("settingsDao",SettingsDao.class);
	Settings sett = new Settings("看见111", "中文t", "127.0.0.1", "io55", "长方", "孙膑", 65655, 7777777, 556565, 1234567, "123@qq.com", "5466", "我是内容，风景不错");
	dao.addSettings(sett);
	
	
}
}

package test.settings;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rcb.dao.SettingsDao;
import com.rcb.entity.Settings;

public class TestSettingsDao {
	@Test
	public void findByUserId(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		SettingsDao dao=
		context.getBean("settingsDao",SettingsDao.class);
		Settings sett=dao.findSettingsByUserId("1");
		System.out.println(sett);
	}
	
@Test
public void addSettings(){
	ApplicationContext context=
			new ClassPathXmlApplicationContext(
					"conf/spring-mybatis.xml");
	SettingsDao dao=
	context.getBean("settingsDao",SettingsDao.class);
	Settings sett = new Settings("一条","1", "中文t", "127.0.0.1", "io55", "长方", "孙膑", 65655, 7777777, 556565, 1234567, "123@qq.com", "5466", "我是内容，风景不错");
	dao.addSettings(sett);
	
	
}
@Test
public void modifySettings(){
	ApplicationContext context=
			new ClassPathXmlApplicationContext(
					"conf/spring-mybatis.xml");
	SettingsDao dao=
	context.getBean("settingsDao",SettingsDao.class);
	Settings sett =dao.findSettingsByUserId("1");
//	Settings sett = new Settings();
//	sett.setId("100");
	sett.setTitle("墨染");
	sett.setPhone(123456);
	int n =dao.modifySettings(sett);
	System.out.println(n);
}
}

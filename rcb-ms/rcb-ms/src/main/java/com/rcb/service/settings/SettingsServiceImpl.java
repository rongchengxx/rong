package com.rcb.service.settings;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.SettingsDao;
import com.rcb.entity.Settings;
@Service("settingsService")
public class SettingsServiceImpl implements SettingsService {
	@Resource
	private SettingsDao dao;
	public Settings findSettingsByUserId(String userId) {
		Settings st=dao.findSettingsByUserId(userId);
		return st;
	}
	public Settings addSettings(String userId,String title, String logo, String uri, String key_word, String contacts,
			int tel, int phone, int fax, int qq, String email, String site, String content) {
		Settings s1 = new Settings();
		s1.setUserId(userId);
		s1.setTitle(title);
		s1.setLogo(logo);
		s1.setUri(uri);
		s1.setKey_word(key_word);
		s1.setContacts(contacts);
		s1.setTel(tel);
		s1.setPhone(phone);
		s1.setFax(fax);
		s1.setQq(qq);
		s1.setEmail(email);
		s1.setSite(site);
		s1.setContent(content);
		dao.addSettings(s1);
		return s1;
	}
	public int modifySettings(String id, String userId, String title, String logo, String uri, String key_word,
			String contacts, int tel, int phone, int fax, int qq, String email, String site, String content) {
		Settings s2=dao.findSettingsByUserId(userId);
		s2.setId(id);
		s2.setUserId(userId);
		s2.setTitle(title);
		s2.setLogo(logo);
		s2.setUri(uri);
		s2.setKey_word(key_word);
		s2.setContacts(contacts);
		s2.setTel(tel);
		s2.setPhone(phone);
		s2.setFax(fax);
		s2.setQq(qq);
		s2.setEmail(email);
		s2.setSite(site);
		s2.setContent(content);
		int n=dao.modifySettings(s2);
		return n;
	}

}

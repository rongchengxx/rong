package com.rcb.service.settings;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.SettingsDao;
import com.rcb.entity.Settings;
@Service("settingsService")
public class SettingsServiceImpl implements SettingsService {
	@Resource
	private SettingsDao dao;
	public Settings findSettingsById(String id) {
		Settings st=dao.findSettingsById(id);
		return st;
	}
	public Settings addSettings(String title, String logo, String uri, String key_word, String contacts,
			int tel, int phone, int fax, int qq, String email, String site, String content) {
		Settings s1 = new Settings("", title, logo, uri, key_word, contacts, tel, phone, fax, qq, email, site, content);
		dao.addSettings(s1);
		return s1;
	}

}

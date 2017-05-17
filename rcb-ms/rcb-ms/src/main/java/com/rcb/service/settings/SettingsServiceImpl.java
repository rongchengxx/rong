package com.rcb.service.settings;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.SettingsDao;
import com.rcb.entity.Settings;
@Service("settingsService")
public class SettingsServiceImpl implements SettingsService {
	@Resource
	private SettingsDao dao;
	public int addSettings(Settings sett) {
		int n =dao.addSettings(sett);
		return n;
		
	}
	public Settings findSettingsById(String id) {
		Settings st=dao.findSettingsById(id);
		return st;
	}

}

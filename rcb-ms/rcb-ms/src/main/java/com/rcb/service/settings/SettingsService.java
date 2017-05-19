package com.rcb.service.settings;

import com.rcb.entity.Settings;

public interface SettingsService {
	public Settings findSettingsById(String id);//通过id查询一条信息 
	public Settings addSettings(String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
			int fax, int qq, String email, String site, String content);//添加设置
}

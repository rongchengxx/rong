package com.rcb.service.settings;

import com.rcb.entity.Settings;

public interface SettingsService {
	public Settings findSettingsByUserId(String userId);//通过id查询一条信息 
	public Settings addSettings(String userId,String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
			int fax, int qq, String email, String site, String content);//添加设置
	public int modifySettings(String id,String userId,String title, String logo, String uri, String key_word, String contacts, int tel, int phone,
			int fax, int qq, String email, String site, String content);//修改
}

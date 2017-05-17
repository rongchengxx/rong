package com.rcb.service.settings;

import com.rcb.entity.Settings;

public interface SettingsService {
	public Settings findSettingsById(String id);//通过id查询一条信息 
	public int addSettings(Settings sett);//添加设置
}

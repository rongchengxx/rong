package com.rcb.dao;

import com.rcb.entity.Settings;

public interface SettingsDao {
	public Settings findSettingsById(String id);//通过id查询一条信息 
	
	public int addSettings(Settings settings);//添加设置
}
package com.rcb.dao;

import com.rcb.entity.Settings;

public interface SettingsDao {
	public Settings findSettingsByUserId(String userId);//通过id查询一条信息 
	
	public void addSettings(Settings settings);//添加设置
	
	public int modifySettings(Settings settings);//修改
}

package com.rcb.dao;

import java.util.List;

import com.rcb.entity.HomeImg;

public interface HomeImgDao {
	public HomeImg findHomeImgById(String id); //通过id查出一条信息
	public void addHomeImg(HomeImg hig);//添加
	public void delHomeImgById(String id);//删除
	public int modifyHomeImg(HomeImg hig);//修改
	public List<HomeImg> findHomeImgAll();//查全部
}

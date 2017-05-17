package com.rcb.service.home_img;

import java.util.List;

import com.rcb.entity.HomeImg;

public interface HomeImgService {
	public HomeImg findHomeImgById(String id); //通过id查出一条信息
	public int addHomeImg(HomeImg hig);//添加
	public int delHomeImgById(String id);//删除
	public int modifyHomeImg(HomeImg hig);//修改
	public List<HomeImg> findHomeImgAll();//查全部
}

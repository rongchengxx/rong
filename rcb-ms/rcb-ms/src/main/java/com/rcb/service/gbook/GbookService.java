package com.rcb.service.gbook;

import java.util.List;

import com.rcb.entity.Gbook;

public interface GbookService {
	public int delGbookById(String id); //通过id删除表中一条信息
	 public int delGbooksById(String... ids);//删除多条
	 public List<Gbook> findGbookByPage(int page);//查找gbook根据page page:从第几条内容开始
	 public String findGbookCount();//查找gbook记录的总条数
}

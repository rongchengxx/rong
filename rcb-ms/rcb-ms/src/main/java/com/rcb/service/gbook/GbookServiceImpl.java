package com.rcb.service.gbook;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.GbookDao;
import com.rcb.entity.Gbook;
@Service("gbookService")
public class GbookServiceImpl implements GbookService {
	@Resource
	private GbookDao dao;
	public int delGbookById(String id) {
		int n=dao.delGbookById(id);
		return n;
	}

	public int delGbooksById(String... id) {
	
		int m = dao.delGbooksById(id);
		return m;
	}

	public List<Gbook> findGbookByPage(int page) {
		List<Gbook> list=dao.findGbookByPage(page);
		return list;
	}

	public String findGbookCount() {
		String p = dao.findGbookCount();
		return p;
	}


}

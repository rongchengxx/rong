package com.rcb.service.home_img;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.HomeImgDao;
import com.rcb.entity.HomeImg;
@Service("homeImgService")
public class HomeImgServiceImpl implements HomeImgService {
	@Resource
	private HomeImgDao dao;
	public HomeImg findHomeImgById(String id) {
		HomeImg hig=dao.findHomeImgById(id);
		return hig;
	}  

	public int addHomeImg(HomeImg hig) {
		int row = dao.addHomeImg(hig);
		return row;
		
	}

	public int delHomeImgById(String id) {
		int n=dao.delHomeImgById(id);
		return n;
	}

	public int modifyHomeImg(HomeImg hig) {
		int m=dao.modifyHomeImg(hig);
		return m;
	}

	public List<HomeImg> findHomeImgAll() {
		 List<HomeImg> list=dao.findHomeImgAll();
		return list;
	}

}

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

	public HomeImg addHomeImg(HomeImg hig) {
		dao.addHomeImg(hig);
		return hig;
		
	}

	public HomeImg delHomeImgById(String id) {
		dao.delHomeImgById(id);
		return null;
		
	}

	public HomeImg modifyHomeImg(String id,String title, String url,String  link,String content,int seq) {
//		HomeImg hig =dao.findHomeImgById(id);
		
		HomeImg hig= new HomeImg();
		hig.setTitle(title);
		hig.setUrl(url);
		hig.setLink(link);
		hig.setContent(content);
		hig.setSeq(seq);
		dao.modifyHomeImg(hig);
		return hig;
	}

	public List<HomeImg> findHomeImgAll() {
		 List<HomeImg> list=dao.findHomeImgAll();
		return list;
	}

	public int modifyHomeImg(HomeImg hig) {
		// TODO Auto-generated method stub
		return 0;
	}


}

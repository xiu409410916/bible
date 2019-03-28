package com.bible.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.commons.ReturnEntity;
import com.bible.model.BannerInfo;
import com.bible.service.BannerInfoSer;

@RestController
@RequestMapping("/bannerInfo")
public class BannerInfoController {

	@Autowired
	private BannerInfoSer bannerInfoSer;
	
	
	/**
	 * 获取一个banner信息
	 * @return
	 */
	@RequestMapping("/getBannerInfo")
	public ReturnEntity<BannerInfo> getBannerInfo() {
		return bannerInfoSer.getInfoById();
	}
	
	
}

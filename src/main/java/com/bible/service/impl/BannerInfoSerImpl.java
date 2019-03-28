package com.bible.service.impl;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.commons.ReturnEntity;
import com.bible.dao.BannerInfoDao;
import com.bible.model.BannerInfo;
import com.bible.service.BannerInfoSer;

@Service
public class BannerInfoSerImpl implements BannerInfoSer {

	@Autowired
	private BannerInfoDao bannerInfoDao;
	
	public ReturnEntity<BannerInfo> getInfoById() {
		Integer bannerId =  RandomUtils.nextInt(1, 23);
		ReturnEntity<BannerInfo> re = new ReturnEntity<BannerInfo>();
		re.setData(bannerInfoDao.findByBannerId(bannerId));
		return re;
	}
	
}

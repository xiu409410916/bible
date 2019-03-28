package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bible.model.BannerInfo;

public interface BannerInfoDao extends JpaRepository<BannerInfo, Integer> {

	
	public BannerInfo findByBannerId(Integer bannerId);
	
}


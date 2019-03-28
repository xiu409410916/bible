package com.bible.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.commons.ReturnEntity;
import com.bible.dao.UserInfoDao;
import com.bible.dao.UserReadDao;
import com.bible.dao.UserThoughtDao;
import com.bible.model.UserInfo;
import com.bible.service.UserInfoSer;

@Service
public class UserInfoSerImpl implements UserInfoSer {

	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private UserReadDao userReadDao;
	
	@Autowired
	private UserThoughtDao userThoughtDao;
	
	/**
	 * 获取用户信息
	 * @return
	 */
	@Transactional
	public ReturnEntity<UserInfo> getUserInfoByOpenId (UserInfo userInfo) {
		ReturnEntity<UserInfo> returnEntity = new ReturnEntity<>();
		//登录
		UserInfo returnUi = userInfoDao.findByUserId(userInfo.getUserId());
		if(!userInfo.getNickName().equals(returnUi.getNickName())
				|| !userInfo.getAvatarUrl().equals(returnUi.getAvatarUrl())
				|| !userInfo.getGender().equals(returnUi.getGender())) {
			returnUi.setNickName(userInfo.getNickName());
			returnUi.setAvatarUrl(userInfo.getAvatarUrl());
			returnUi.setGender(userInfo.getGender());
			userInfoDao.updateUserInfo(returnUi);
		}
		
		returnEntity.setData(returnUi);
		return returnEntity;
	}
	
	
	/**
	 * 获取用户信息
	 * @return
	 */
	public UserInfo getUserInfoByUserId (Integer userId) {
		return userInfoDao.findByUserId(userId);
	}
	
	
	/**
	 * 获取用户   累计摇一摇次数/感动分享次数
	 */
	public Map<String, Integer> getCountByUserId(Integer userId){
		Map<String, Integer> map = new HashMap<>();
		int readCount = userReadDao.getCountByUserId(userId);
		map.put("readCount", readCount);
		int thoughtCount = userThoughtDao.getCountByUserId(userId);
		map.put("thoughtCount", thoughtCount);
		return map;
	}

	
	
}

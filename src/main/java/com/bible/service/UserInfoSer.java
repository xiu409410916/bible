package com.bible.service;

import java.util.Map;

import com.bible.commons.ReturnEntity;
import com.bible.model.UserInfo;

public interface UserInfoSer {

	/**
	 * 获取用户信息
	 * @return
	 */
	public ReturnEntity<UserInfo> getUserInfoByOpenId (UserInfo userInfo);
	
	/**
	 * 获取用户信息
	 * @return
	 */
	public UserInfo getUserInfoByUserId (Integer userId);
	
	
	/**
	 * 获取用户   累计摇一摇次数/感动分享次数
	 */
	public Map<String, Integer> getCountByUserId(Integer userId);
	
	
}

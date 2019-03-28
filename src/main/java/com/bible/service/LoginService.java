package com.bible.service;

import com.bible.model.UserInfo;


/**
 * 登录
 * @author xiuxiuzhang
 *
 */
public interface LoginService {
	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 */
	public UserInfo login(String openId,Integer recUserId);
	
}

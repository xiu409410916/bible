package com.bible.service;

import com.bible.model.UserPraise;

public interface UserPraiseSer {
	
	/**
	 * 保存用户点赞 圣经 记录 
	 * @param userPraise
	 */
	public void saveUserPraise(UserPraise userPraise);
	
	
	/**
	 * 删除用户点赞 圣经 记录 
	 * @param userPraise
	 */
	public void deleteUserPraise(UserPraise userPraise);

}

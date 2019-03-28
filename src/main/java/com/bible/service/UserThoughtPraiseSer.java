package com.bible.service;

import com.bible.model.UserThoughtPraise;

public interface UserThoughtPraiseSer {
	
	/**
	 * 保存用户点赞 感悟 记录 
	 * @param userPraise
	 */
	public void saveUserThoughtPraise(UserThoughtPraise userThoughtPraise);
	
	
	/**
	 * 删除用户点赞 感悟 记录 
	 * @param userPraise
	 */
	public void deleteUserPraise(UserThoughtPraise userThoughtPraise);
}

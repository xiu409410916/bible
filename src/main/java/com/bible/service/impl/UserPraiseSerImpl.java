package com.bible.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.dao.UserPraiseDao;
import com.bible.model.UserPraise;
import com.bible.service.UserPraiseSer;

@Service
public class UserPraiseSerImpl implements UserPraiseSer {
	
	@Autowired
	private UserPraiseDao userPraiseDao;
	
	
	/**
	 * 保存用户点赞 圣经 记录 
	 * @param userPraise
	 */
	public void saveUserPraise(UserPraise userPraise) {
		userPraise.setPraiseId(userPraise.getUserId()+""+userPraise.getSectionId());
		userPraise.setCreateTime(new Timestamp(System.currentTimeMillis()));
		userPraiseDao.save(userPraise);
	}
	
	
	/**
	 * 删除用户点赞 圣经 记录 
	 * @param userPraise
	 */
	public void deleteUserPraise(UserPraise userPraise) {
		userPraiseDao.deleteById(userPraise.getUserId()+""+userPraise.getSectionId());
	}


}

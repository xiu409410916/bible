package com.bible.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bible.dao.UserThoughtPraiseDao;
import com.bible.model.UserThoughtPraise;
import com.bible.service.UserThoughtPraiseSer;


@Service
public class UserThoughtPraiseSerImpl implements UserThoughtPraiseSer {

	@Autowired
	private UserThoughtPraiseDao userThoughtPraiseDao;
	
	
	/**
	 * 保存用户点赞 感悟 记录 
	 * @param userPraise
	 */
	public void saveUserThoughtPraise(UserThoughtPraise userThoughtPraise) {
		userThoughtPraise.setThoughtPraiseId(userThoughtPraise.getUserId()+""+userThoughtPraise.getThoughtId());
		userThoughtPraise.setCreateTime(new Timestamp(System.currentTimeMillis()));
		userThoughtPraiseDao.save(userThoughtPraise);
	}
	
	
	/**
	 * 删除用户点赞 感悟 记录 
	 * @param userPraise
	 */
	public void deleteUserPraise(UserThoughtPraise userThoughtPraise) {
		userThoughtPraiseDao.deleteById(userThoughtPraise.getUserId()+""+userThoughtPraise.getThoughtId());
	}

	
	
}

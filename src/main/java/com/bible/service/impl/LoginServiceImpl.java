package com.bible.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bible.dao.UserInfoDao;
import com.bible.model.UserInfo;
import com.bible.service.LoginService;


/**
 * 登录
 * @author xiuxiuzhang
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 */
	@Transactional
	public UserInfo login(String openId,Integer recUserId) {
		
		UserInfo returnUi = userInfoDao.findByOpenId(openId);
		if(returnUi == null) {
			returnUi = new UserInfo();
			returnUi.setOpenId(openId);
			returnUi.setStatus(1);
			returnUi.setCreateTime(new Timestamp(System.currentTimeMillis()));
			returnUi.setRecUserId(recUserId);
			returnUi = userInfoDao.save(returnUi);
		}
		return returnUi;
	}
	
}

package com.bible.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bible.commons.ReturnEntity;
import com.bible.dao.UserInfoDao;
import com.bible.dao.UserThoughtDao;
import com.bible.dao.UserThoughtPraiseDao;
import com.bible.model.UserInfo;
import com.bible.model.UserThought;
import com.bible.model.UserThoughtPraise;
import com.bible.service.UserThoughtSer;


@Service
public class UserThoughtSerImpl implements UserThoughtSer {

	@Autowired
	private UserThoughtDao userThoughtDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Autowired
	private UserThoughtPraiseDao userThoughtPraiseDao;
	
	
	
	/**
	 * 新增一个用户的感悟
	 * @param userThought
	 * @return
	 */
	public ReturnEntity<String> addUserThought(UserThought userThought){
		userThought.setCreateTime(new Timestamp(System.currentTimeMillis()));
		userThoughtDao.save(userThought);
		ReturnEntity<String> re = new ReturnEntity<String>();
		re.setData(userThoughtDao.getCountBySection(userThought.getSectionId())+"");
		return re;
	}
	
	
	/**
	 * 查询“圣经一个节”下面的感悟
	 * @return
	 */
	public Page<UserThought> findPageList(UserThought userThought) {
		Integer userId = userThought.getUserId();
		userThought.setUserId(null);
		Sort sort = new Sort(Sort.Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(userThought.getPageNum(), userThought.getPageSize(), sort);
		
		Example<UserThought> ex = Example.of(userThought);
		Page<UserThought> userThoughts = userThoughtDao.findAll(ex,pageable);
		
		Map<Integer, UserInfo> urlMap = new HashMap<>();
		for (UserThought ut : userThoughts.getContent()) {
			if(!urlMap.containsKey(ut.getUserId())) {
				UserInfo ui = userInfoDao.findByUserId(ut.getUserId());
				urlMap.put(ut.getUserId(), ui);
			}
			ut.setAvatarUrl(urlMap.get(ut.getUserId()).getAvatarUrl());
			ut.setNickName(urlMap.get(ut.getUserId()).getNickName());
			//用户是否点赞
			UserThoughtPraise utp = userThoughtPraiseDao.findByThoughtPraiseId(userId+""+ut.getThoughtId());
			ut.setIsPraise(utp == null ? 0 : 1);
			//用户点赞数量
			int praiseCount = userThoughtPraiseDao.getCountByThoughtId(ut.getThoughtId());
			ut.setPraiseCount(praiseCount);
		}
		
		return userThoughts;
		
	}
	
	
	/**
	 * 修改一个用户的感悟
	 * @param userThought
	 * @return
	 */
	@Transactional
	public ReturnEntity<String> updateUserThought(UserThought userThought){
		userThought.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		userThoughtDao.updateUserThought(userThought);
		return new ReturnEntity<>();
	}
	
}

package com.bible.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bible.dao.UserReadDao;
import com.bible.model.UserRead;
import com.bible.service.UserReadSer;


@Service
public class UserReadSerImpl implements UserReadSer {
	
	@Autowired
	private UserReadDao userReadDao;
	
	
	/**
	 * 查询 用户的 阅读记录
	 * @return
	 */
	public Page<UserRead> findPageList(UserRead userRead) {
		Sort sort = new Sort(Sort.Direction.DESC, "createTime");
		Pageable pageable = new PageRequest(userRead.getPageNum(), userRead.getPageSize(), sort);
		
		Example<UserRead> ex = Example.of(userRead);
		Page<UserRead> userReads = userReadDao.findAll(ex,pageable);
		
		return userReads;
	}

}

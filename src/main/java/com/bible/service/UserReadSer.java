package com.bible.service;

import org.springframework.data.domain.Page;

import com.bible.model.UserRead;

public interface UserReadSer {

	/**
	 * 查询 用户的 阅读记录
	 * @return
	 */
	public Page<UserRead> findPageList(UserRead userRead);
	
	
}

package com.bible.service;

import org.springframework.data.domain.Page;

import com.bible.commons.ReturnEntity;
import com.bible.model.UserThought;

public interface UserThoughtSer {

	/**
	 * 新增一个用户的感悟
	 * @param userThought
	 * @return
	 */
	public ReturnEntity<String> addUserThought(UserThought userThought);
	
	
	/**
	 * 查询“圣经一个节”下面的感悟
	 * @return
	 */
	public Page<UserThought> findPageList(UserThought userThought);
	
	

	/**
	 * 修改一个用户的感悟
	 * @param userThought
	 * @return
	 */
	public ReturnEntity<String> updateUserThought(UserThought userThought);
	
	
	
}

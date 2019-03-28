package com.bible.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bible.commons.ReturnEntity;
import com.bible.model.UserThought;
import com.bible.service.UserInfoSer;
import com.bible.service.UserThoughtSer;


@RestController
@RequestMapping("/userThought")
public class UserThoughtController {
	
	@Autowired
	private UserThoughtSer userThoughtSer;
	
	@Autowired
	private UserInfoSer userInfoSer;
	
	
	/**
	 *  新增一个用户的感悟
	 * @param userThought
	 * @return
	 */
	@RequestMapping(value="/addUserThought", method = RequestMethod.POST)
	public ReturnEntity<String> addUserThought(@RequestBody UserThought userThought){
		return userThoughtSer.addUserThought(userThought);
	}
	
	/**
	 *  修改一个用户的感悟
	 * @param userThought
	 * @return
	 */
	@RequestMapping(value="/updateUserThought", method = RequestMethod.POST)
	public ReturnEntity<String> updateUserThought(@RequestBody UserThought userThought){
		return userThoughtSer.updateUserThought(userThought);
	}
	
	
	
	
	/**
	 * 查询“圣经一个节”下面的感悟
	 * @return
	 */
	@RequestMapping("/findPageList")
	public Page<UserThought> findPageList(UserThought userThought) {
//		userThought.setSectionId(null);    //上线前注释掉
		Page<UserThought> page = userThoughtSer.findPageList(userThought);
		return page;
	}
	
	
	/**
	 * 查询“一个用户”的感悟
	 * @return
	 */
	@RequestMapping("/findUserPageList")
	public Page<UserThought> findUserPageList(UserThought userThought) {
		return userThoughtSer.findPageList(userThought);
	}

}

package com.bible.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.commons.ReturnEntity;
import com.bible.model.UserPraise;
import com.bible.service.UserPraiseSer;

@RestController
@RequestMapping("/userPraise")
public class UserPraiseController {

	@Autowired
	private UserPraiseSer userPraiseSer;
	
	/**
	 * 保存用户点赞 圣经 记录 
	 * @param userPraise
	 */
	@RequestMapping("/saveUserPraise")
	public ReturnEntity<String> saveUserPraise(UserPraise userPraise) {
		userPraiseSer.saveUserPraise(userPraise);
		return new ReturnEntity<>();
	}
	
	
	/**
	 * 删除用户点赞 圣经 记录 
	 * @param userPraise
	 */
	@RequestMapping("/deleteUserPraise")
	public ReturnEntity<String> deleteUserPraise(UserPraise userPraise){
		userPraiseSer.deleteUserPraise(userPraise);
		return new ReturnEntity<>();
	}
	
}

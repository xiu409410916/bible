package com.bible.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.commons.ReturnEntity;
import com.bible.model.UserThoughtPraise;
import com.bible.service.UserThoughtPraiseSer;

@RestController
@RequestMapping("/userThoughtPraise")
public class UserThoughtPraiseController {

	@Autowired
	private UserThoughtPraiseSer userThoughtPraiseSer;
	
	/**
	 * 保存用户点赞 感悟 记录 
	 * @param userPraise
	 */
	@RequestMapping("/saveUserThoughtPraise")
	public ReturnEntity<String> saveUserThoughtPraise(UserThoughtPraise userThoughtPraise) {
		userThoughtPraiseSer.saveUserThoughtPraise(userThoughtPraise);
		return new ReturnEntity<>();
	}
	
	
	/**
	 * 删除用户点赞 感悟 记录 
	 * @param userPraise
	 */
	@RequestMapping("/deleteUserThoughtPraise")
	public ReturnEntity<String> deleteUserThoughtPraise(UserThoughtPraise userThoughtPraise) {
		userThoughtPraiseSer.deleteUserPraise(userThoughtPraise);
		return new ReturnEntity<>();
	}
	
}


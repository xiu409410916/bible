package com.bible.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bible.commons.ErrorCode;
import com.bible.commons.ReturnEntity;
import com.bible.dto.WxLoginInfo;
import com.bible.model.UserInfo;
import com.bible.model.UserRead;
import com.bible.service.UserInfoSer;
import com.bible.service.UserReadSer;


@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	
	@Autowired
	private UserInfoSer userInfoSer;
	
	@Autowired
	private UserReadSer userReadSer;

	/**
	 * 获取用户信息
	 * @param wxLoginInfo
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoByOpenId", method = RequestMethod.POST)
	public ReturnEntity<UserInfo> getUserInfoByOpenId (@RequestBody WxLoginInfo wxLoginInfo) {
		ReturnEntity<UserInfo> returnEntity = new ReturnEntity<>();
		UserInfo ui = wxLoginInfo.getUserInfo();
		if (ui == null) {
			returnEntity.setErrorCode(ErrorCode.ERROR);
			returnEntity.setMessage("失败");
			return returnEntity;
		}
		returnEntity = userInfoSer.getUserInfoByOpenId(ui);
		return returnEntity;
	}
	
	
	/**
	 * 查询 用户的 阅读记录
	 * @return
	 */
	@RequestMapping("/findUserReadPageList")
	public Page<UserRead> findPageList(UserRead userRead) {
		return userReadSer.findPageList(userRead);
	}
	
	/**
	 * 获取用户   累计摇一摇次数/感动分享次数
	 */
	@RequestMapping("/getCountByUserId")
	public ReturnEntity<Map<String, Integer>> getCountByUserId(Integer userId){
		ReturnEntity<Map<String, Integer>> re = new ReturnEntity<>();
		re.setData(userInfoSer.getCountByUserId(userId));
		return re;
	}
	
}

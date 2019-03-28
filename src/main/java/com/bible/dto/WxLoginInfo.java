package com.bible.dto;

import com.bible.model.UserInfo;

/**
 * 微信登录
 * @author xiuxiuzhang
 *
 */
public class WxLoginInfo {

    private String code;
    
    private Integer recUserId;
    
    private UserInfo userInfo;
    
    
    
	public Integer getRecUserId() {
		return recUserId;
	}
	public void setRecUserId(Integer recUserId) {
		this.recUserId = recUserId;
	}
	public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
    
}

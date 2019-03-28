package com.bible.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bible.commons.ErrorCode;
import com.bible.commons.ReturnEntity;
import com.bible.dto.WxLoginInfo;
import com.bible.model.UserInfo;
import com.bible.service.HttpService;
import com.bible.service.LoginService;
import com.bible.util.Test;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.exception.WxErrorException;

/**
 * 用户登录
 * 
 * @author xiuxiuzhang
 *
 */
@RestController()
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private WxMaService wxMaService;
	
	@Autowired
	private HttpService httpService;
	
	/**
	 * 使用微信登录
	 * @param wxLoginInfo
	 * @return
	 */
	@RequestMapping(value = "/login_by_weixin", method = RequestMethod.POST)
	public ReturnEntity<Map<String, Object>> loginByWeixin (@RequestBody WxLoginInfo wxLoginInfo) {
		ReturnEntity<Map<String, Object>> returnEntity = new ReturnEntity<>();
		if (StringUtils.isEmpty(wxLoginInfo.getCode())) {
			returnEntity.setErrorCode(ErrorCode.ERROR);
			returnEntity.setMessage("失败");
			return returnEntity;
		}
		//获取openid和sessionkey
		String sessionKey = null;
		String openId = null;
		try {
			WxMaJscode2SessionResult result = wxMaService.getUserService().getSessionInfo(wxLoginInfo.getCode());
			sessionKey = result.getSessionKey();
			System.out.println(sessionKey);
			openId = result.getOpenid();
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		if (sessionKey == null || openId == null) {
			returnEntity.setErrorCode(ErrorCode.ERROR);
			returnEntity.setMessage("失败");
			return returnEntity;
		}
		//登录
		UserInfo userInfo = loginService.login(openId,wxLoginInfo.getRecUserId());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userInfo", userInfo);
		
		returnEntity.setData(map);
		return returnEntity;
	}
	
	
	
	/**
	 * 使用微信登录
	 * @param wxLoginInfo
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test (Integer userId) {
		Test t = new Test();
		t.getQrCode(userId);
	}
	

	
	  /**
     * 生成 用户的 二维码
     * @param scene
     * @param page
     * @return
     */
    @RequestMapping(value = "/qrCode",method = RequestMethod.GET)
    public ReturnEntity<String> getQrCode(Integer userId){
        ReturnEntity<String> returnEntity= new ReturnEntity<>();
        String result = httpService.getQrCode(userId);
        returnEntity.setData(result);
        return returnEntity;
    }
	
}

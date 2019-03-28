package com.bible.service;

/**
 * @program: CarEye
 * @description: 请求外部地址服务
 * @author: Zhu Jia
 * @create: 2018-09-18 21:18
 **/
public interface HttpService {

    public String httpsRequest(String requestUrl, String requestMethod, String outputStr);
	
	
    public String getAccessToken();
    
    public String getQrCode(Integer userId);
    
}

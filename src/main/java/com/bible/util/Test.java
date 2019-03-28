package com.bible.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bible.service.HttpService;

@Component
public class Test {
	
	@Autowired
	private HttpService httpService;
	
	private static String appid="wx8564e761213b8fff";
	private static String secret="e5710385f3d0d28664662ddf1d5aa67c";
	
    public String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            System.out.println("连接超时：{}");
        } catch (Exception e) {
            System.out.println("https请求异常：{}");
        }
        return null;
    }
	
	 public String getAccessToken() {
	        String tmpurl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	        String url = tmpurl.replace("APPID", appid);
	        url = url.replace("APPSECRET", secret);
	        JSONObject resultJson =null;
	        String result = httpsRequest(url, "POST", null);
	        try {
	            resultJson =  JSONObject.parseObject(result);
	            String errmsg = (String) resultJson.get("errmsg");
	            if(!"".equals(errmsg) && errmsg != null){  //如果为errmsg为ok，则代表发送成功，公众号推送信息给用户了。
	                return "error";
	            }
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	        System.err.println((String) resultJson.get("access_token"));
	        return (String) resultJson.get("access_token");
	    }

	 
	 
	 public String getQrCode(Integer userId) {
		 Test t = new Test();
			String fileName = userId + ".png";
			String resultUrl = "http://127.0.0.1/qrcode/user/"+ fileName;
			File file = new File("/Users/xiuxiuzhang/software/tomcat/tomcat-solr/webapps/qrcode/user/"+fileName);
			if (file.exists()) {
				return resultUrl;
			}
			System.out.println("select fileName :" + file.getAbsolutePath());

			RestTemplate rest = new RestTemplate();
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				String requestUrl = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";
				String token = httpService.getAccessToken();
				requestUrl = requestUrl.replace("ACCESS_TOKEN", token);

				JSONObject json = new JSONObject();
				json.put("scene", userId);
//				json.put("page", “”);
				json.put("width", 430);
				json.put("auto_color", false);

				JSONObject color = new JSONObject();
				color.put("r", 0);
				color.put("g", 0);
				color.put("b", 0);
				json.put("line_color", color);

				MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
				HttpEntity requestEntity = new HttpEntity(json, headers);
				ResponseEntity<byte[]> entity = rest.exchange(requestUrl, HttpMethod.POST, requestEntity, byte[].class,
						new Object[0]);
				byte[] result = entity.getBody();
				inputStream = new ByteArrayInputStream(result);
				file.createNewFile();
				System.out.println("create file success");
				outputStream = new FileOutputStream(file);
				int len = 0;
				byte[] buf = new byte[1024];
				while ((len = inputStream.read(buf, 0, 1024)) != -1) {
					outputStream.write(buf, 0, len);
				}
				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (outputStream != null) {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return resultUrl;
		}
	 
	 public static void main(String[] args) {
		Test t = new Test();
		t.getQrCode(1);
	}
}

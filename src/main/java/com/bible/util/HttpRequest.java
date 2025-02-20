package com.bible.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpRequest {
	
	  /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url           发送请求的URL
     * @param param         请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL          所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
//            connection.setRequestProperty("host", "www.godcom.net");
//            connection.setRequestProperty("accept-encoding", "gzip, deflate");
            connection.setRequestProperty("Content-Type", "text/html");
//            connection.setRequestProperty("Accept-Ranges", "bytes");
//            connection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            connection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"gb2312"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url          发送请求的 URL
     * @param param        请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return             所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
    
    
    public static String ffff(String url) throws ClientProtocolException, IOException {
    	CloseableHttpClient client = HttpClients.createDefault();
		HttpGet http = new HttpGet(url);
//		http.setHeader("Accept-Encoding", "gzip, deflate");
//		http.setHeader("Host", "car.bitauto.com");
//		http.setHeader("Content-Type", "text/html; charset=gb2312");
		http.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
		CloseableHttpResponse response = client.execute(http);

        String html = EntityUtils.toString(response.getEntity()); 
        return html;
    }
    
    public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println(HttpRequest.sendGet("http://www.godcom.net/hhb/cuvgb.htm", ""));
    	System.out.println(HttpRequest.ffff("http://www.godcom.net/hhb/cuvgb.htm"));
	}
	

}

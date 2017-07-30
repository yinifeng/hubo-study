package com.hubo.weixin.httppost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class Test {
	public static void main(String[] args) {
		WechatTemplate wt = new WechatTemplate();
		wt.setTouser("st123456");
		wt.setTemplate_id("sdfsdddddd");
		wt.setTopcolor("#000FF45");
		wt.setUrl("http://music.163.com/#/song?id=27867140");
//		wt.getData().put("first", new TemplateData("交易信息", "#000F3"));
//		wt.getData().put("keyword1", new TemplateData("牛肉面", "#000F3"));
//		wt.getData().put("keyword2", new TemplateData("20.00元", "#000F3"));
//		wt.getData().put("remark", new TemplateData("更多信息", "#000F3"));

		//System.out.println(JSONObject.fromObject(wt));

		String url = "http://127.0.0.1:8080/springmvc-003/services/testJsonServer2";

		String str = Test.httppost(url, JSONObject.fromObject(wt).toString());
		//String str = Test.httppost(url,  "jsonStr="+JSONObject.fromObject(wt).toString());
		System.out.println(str);
	}

	public static String httppost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuilder result = new StringBuilder();

		try {
			URL realUrl = new URL(url);
			// 打开URL的连接
			URLConnection conn = realUrl.openConnection();
			//设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "keep-Alive");
			conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			//发送post请求必须设置如下两行
			conn.setDoInput(true);
			conn.setDoOutput(true);
			//获取URLConnection对象对应的输出流
			out=new PrintWriter(conn.getOutputStream());
			//发送请求参数
			out.print(param);
			//flush输出流的缓冲
			out.flush();
			//定义BufferedReader输入流来读取URL的响应
			in=new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "GBK"));
			String line;
			while((line=in.readLine())!=null){
				result.append(line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}


		return result.toString();
	}
}

package com.hubo.springmvc.jsonserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 此类用来测试 HttpClient 请求 json 响应json 字符串
 * 
 * @author hubo
 * 
 */
@Controller
@RequestMapping(value = "/services")
public class JsonServer {

	@ResponseBody
	@RequestMapping(value = "/testJsonServer",method=RequestMethod.POST)
	public String testJsonServer(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		// 通过Get方式去url拼接的键值对，post方式取不到
		// String json=request.getParameter("param");
		request.setCharacterEncoding("UTF-8");// 设置编码方式
		// post 方式读取字符流
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				request.getInputStream()));
		// BufferedReader reader=new BufferedReader(new
		// InputStreamReader(request.getInputStream(),"UTF-8"));
		String jsonStr = null;
		StringBuilder result = new StringBuilder();

		try {
			while ((jsonStr = reader.readLine()) != null) {
				result.append(jsonStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		reader.close();
		// 读取数据
		System.out.println("=======>");
		System.out.println(result.toString());

		String str = "{\"error\":\"0\",\"msg\":\"ok\"}";

		return str;
	}

	@ResponseBody
	@RequestMapping(value = "/testJsonServer2",method=RequestMethod.POST)
	public String testJson2(@RequestBody String code) {

		System.out.println(code);
		String str = "{\"error\":\"0\",\"msg\":\"ok\"}";
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value = "/testJsonServer3",method=RequestMethod.POST)
	public String testJson3(@RequestParam("jsonStr") String jsonStr) {

		System.out.println(jsonStr);
		String str = "{\"error\":\"0\",\"msg\":\"ok\"}";
		return str;
	}
}

package com.hubo.springmvc.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;


/**
 * 自定义视图，可以实现View接口整合其他视图
 * 相应的整合Excel可以实现AbstractExcelView抽象类的buildExcelDocument方法
 * 
 * @author hubo
 *
 */
@Component
public class HelloView implements View{

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.getWriter().print("hello view,time: "+new Date());
	}

}

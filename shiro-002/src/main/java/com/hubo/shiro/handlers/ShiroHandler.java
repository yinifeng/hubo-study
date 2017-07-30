package com.hubo.shiro.handlers;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hubo.shiro.service.ShiroService;

@Controller
@RequestMapping(value="shiro")
public class ShiroHandler {
	@Autowired
	public ShiroService shiroService;
	
	@RequestMapping(value="/testShiroAnnation")
	public String testShiroAnnation(HttpSession session){
		//设置session，用shiro的session获取web的session'
		session.setAttribute("key", "session123456");	
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam(value="username") String username,
			@RequestParam(value="password") String password){
		Subject currentUser = SecurityUtils.getSubject();
		
		if (!currentUser.isAuthenticated()) {
        	/**把用户名和密码封装为UsernamePasswordToken对象*/
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //System.out.println("toke的hashcode: "+token.hashCode());
            
            /**rememberMe*/ //这个记住登录
            token.setRememberMe(true);
            try {
            	/**登录*/
                currentUser.login(token);
            } 
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {/**所有认证异常 异常 的父类*/
                //unexpected condition?  error?
            	System.out.println("用户名或密码错误！！"+ae.getMessage());
            }
        }

		return "redirect:/list.jsp";
	}
}

package com.hubo.springmvc.mvctest;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hubo.springmvc.vo.User;


@SessionAttributes(value={"user"},types={String.class})
@RequestMapping("/springMvc")
@Controller
public class SpringMvcTest {
	
	private static final String SUCCESS="success";
	
	
	/**
	 * 重定向
	 * @return
	 */
	@RequestMapping(value="/testRedirect")
	public String testRedirect(){
		System.out.println("Test Redirect");
		return "redirect:/index.jsp";
	}
	
	/**
	 * 自定义视图 实现 View 接口的类的 注册到容器中的ID
	 * @return
	 */
	@RequestMapping(value="/testView")
	public String testView(){
		System.out.println("Test View");
		return "helloView";
	}
	
	
	@RequestMapping(value="/testViewAndViewResolver")
	public String testViewAndViewResolver(){
		System.out.println("Test ViewAndViewResolver");
		return SUCCESS;
	}
	
	/**
	 * @ModelAttribute 标记的方法会在 没个目标方法执行之前被SpringMVC调用
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,
			Map<String,Object> map){
		System.out.println("ModelAttribute Method");
		if(id!=null){
			User user=new User(1, "tom", "123456", "tom@qq.com", 12);
			//map.put("user", user);
			map.put("abc", user);
		}
	}
	
	
	/**
	 * @ModelAttribute(value="abc")修饰的方法 的value 为request域中key，若不修饰默认 类名首字母小写
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testModelAttributes")
	public String testModelAttributes(@ModelAttribute(value="abc") User user){
		System.out.println("Test ModelAttributes: "+user);
		return SUCCESS;
	}
	
	/**
	 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外（实际上使用的是value属性值）
	 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（实际上使用的是types 属性值）
	 * 注意：这个注解只能放在类的上面，不能放到方法上面
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/testSessionAttributes")
	public String testSessionAttributes(Map<String,Object> map){
		map.put("user", new User("tom", "123", "tom@qq.com", 21));
		map.put("school", "oracle");	
		return SUCCESS;
	}
	
	/**
	 * 目标方法可以添加Map类型（实际上也可以是 Model 类型或 ModelMap 类型）的参数
	 * @param map
	 * @return
	 */
	@RequestMapping(value="testMap")
	public String testMap(Map<String,Object> map){
		System.out.println(map.getClass());
		map.put("names", Arrays.asList("tom","mick","jack","marry"));
		return SUCCESS;
	}
	
	/**
	 * 目标方法的返回值可以是ModelAndView 类型
	 * 其中包含视图和模型数据信息（对象，list，map集合等）
	 * SpringMVC 会把ModelAndView 的 model中的数据放入到 request 域对象中。
	 * @return
	 */
	@RequestMapping(value="/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName=SUCCESS;
		ModelAndView modelAndView=new ModelAndView(viewName);
		modelAndView.addObject("time", new Date());
		
		return modelAndView;		
	}
	
	
	/**
	 * 可以使用Servlet 原生的API 作为目标方法的参数，具体支持的类型如下
	 * @param request
	 * @param response
	 * @param out
	 * @throws IOException
	 */
	@RequestMapping(value="/testServletApi")
	public void testServletAPI(HttpServletRequest request,
			HttpServletResponse response,Writer out) throws IOException{
		
		System.out.println("Test ServletApi: request: "+request+",response: "+response);
		out.write("hello servlet");
	}
	
	/**
	 * 映射pojo的请求参数
	 * 而且可以是级联参数
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/testPojo",method=RequestMethod.POST)
	public String testPojo(User user){
		System.out.println("Test Pojo: "+user);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID") String cookie){
		System.out.println("Test CookieValue: JSESSIONID="+cookie);
		return SUCCESS;
	}
	
	/**
	 * 同RequestParam 用法
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/testRequestHeader")
	public String testRquestHeader(@RequestHeader(value="Accept-Language") String str){
		System.out.println("Test RequestHeader: Accept-Language="+str);
		return SUCCESS;
	}
	
	/**
	 * @RequestParam 映射请求参数
	 * @param username
	 * @param age
	 * @return
	 */
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String username,
			@RequestParam(value="age",required=false,defaultValue="0") int age){
		System.out.println("test RequestParam: username="+username+",age="+age);
		return SUCCESS;
	}
	
	/**
	 * REST 风格 的URL
	 * 以CRUD 为例:
	 * 新增：/order POST
	 * 修改:/order/1 PUT		update?id=1
	 * 获取:/order/1 GET		get?id=1
	 * 删除:/order/1 DELETE  delete?id=1
	 * 
	 * 如何发送PUT 请求 和DELETE 请求呢？
	 * 1.需要配置HiddenHttpMethodFilter拦截器
	 * 2.需要发送 POST	请求
	 * 3.需要在发送 POST 请求时携带一个name="_method" 的隐藏域，值为DELETE 或 PUT
	 * 
	 * 在spingMvc 的目标方法中如何获取id呢？
	 * 使用@PathVariable 注解
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/testRestPut/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id){
		System.out.println("test Rest Put:"+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRestDelete/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id){
		System.out.println("test Rest Delete:"+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRestPost",method=RequestMethod.POST)
	public String testRestPost(){
		System.out.println("test Rest Post");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRestGet/{id}",method=RequestMethod.GET)
	public String testRestGet(@PathVariable("id") Integer id){
		System.out.println("test Rest Get:"+id);
		return SUCCESS;
	}
	
	/**
	 * PathVariable 设置占位符id
	 * 可以获取请求的值
	 * 
	 */
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id){
		System.out.println("test PathVariable:"+id);
		return SUCCESS;
	}
	
	/**
	 * 支持ant风格url
	 * *代表占位符任意个字符
	 * @return
	 */
	@RequestMapping(value="/testAnt/*/abc")
	public String testAnt(){
		System.out.println("Test Ant");
		return SUCCESS;
	}
	
	/**
	 * 了解
	 * RequestMapping 的params 定义请求参数，
	 * 必须包含username，和age！=10的参数
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value="testParamsAndHeaders",
			params={"username","age!=10"},headers={"Accept-Language=zh-CN,zh;q=0.8"})
	public String testParamsAndHeaders(){
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	
	/**
	 * 指定POST请求
	 * 如果GET请求则会报错
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("Test Method Post");
		return SUCCESS;
	}
	
	/**
	 * RequestMapping 既可以修饰类，也可以修饰方法
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("test RequestMapping");
		return SUCCESS;
	}
	
}

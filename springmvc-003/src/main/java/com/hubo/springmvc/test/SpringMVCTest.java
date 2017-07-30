package com.hubo.springmvc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.jws.HandlerChain;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import com.hubo.springmvc.crud.dao.EmployeeDao;
import com.hubo.springmvc.crud.entities.Employee;

@Controller
public class SpringMVCTest {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping(value="/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
		int[] arr=new int[10];
		System.out.println(arr[i]);
		return "success";
	}
	
	/**
	 * 处理默认 异常 的DefaultHandlerExceptionResolver 异常解析器
	 * 例如：Get 请求 POST 请求
	 * HTTP Status 405 - Request method 'GET' not supported
	 * @param i
	 * @return
	 */
	@RequestMapping(value="testDefaultHandlerExceptionResolver",method=RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver...");
		
		return "success";
	}
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="测试")
	@RequestMapping(value="/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
		if(i==13){
			throw new UserMatchsNotFoundException();
		}
		return "success";
	}
	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView handleRuntimeException(Exception ex){
//		System.out.println("[出异常了]： "+ex);
//		ModelAndView mv=new ModelAndView("error");		
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
//	@ExceptionHandler({ArithmeticException.class})
//	public ModelAndView handleArithmeticException(Exception ex){
//		System.out.println("出异常了： "+ex);
//		ModelAndView mv=new ModelAndView("error");		
//		mv.addObject("exception", ex);
//		return mv;
//	}
	
	@RequestMapping(value="/testExceptionHandlerExceptionResovler")
	public String testExceptionHandlerExceptionResovler(@RequestParam("i") int i){
		System.out.println("result: "+(10/i));
		return "success";
	}
	
	/**
	 * 测试文件上传
	 * @param desc
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/testUploadFile")
	public String testUploadFile(@RequestParam(value="desc") String desc,
			@RequestParam(value="file") MultipartFile file) throws IOException{
		System.out.println("Desc: "+desc);
		System.out.println("OriginalFilename: "+file.getOriginalFilename());
		System.out.println("InputStream: "+file.getInputStream());		
		return "success";
	}
	
	/**
	 * 测试国际化和中英文切换
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="/i18n")
	public String testI18n(Locale locale){
		String message = messageSource.getMessage("i18n.user", null, locale);
		System.out.println(message);
		return "i18n";
	}
	
	/**
	 * 测试文件下载
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
		byte[] body=null;
		
		ServletContext servletContext = session.getServletContext();
		InputStream is = servletContext.getResourceAsStream("/files/abc.txt");
		body=new byte[is.available()];
		is.read(body);
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		
		HttpStatus statusCode=HttpStatus.OK;

		ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	
	/**
	 * 测试文件上传
	 * 这种方式做不了文件上传，还需判断 表单中 文本域 和 文件域
	 * @param body
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);		
		return "HelloWorld! "+new Date();
	}
	
	/**
	 * 测试响应json
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	
	/**
	 * 测试自定义类型转换器
	 * lastName-email-gender-department.id 转换成 Employee对象
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/testConversionServiceConveter",method=RequestMethod.POST)
	public String testConversionServiceConveter(@RequestParam(value="employee") Employee employee){
		System.out.println("自定义转换器转换---->"+employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
}

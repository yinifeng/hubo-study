package com.hubo.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubo.spring.hibernate.dao.BookShopDao;
import com.hubo.spring.hibernate.service.BookShopService;

@Service
public class BookShopServiceImpl implements BookShopService{
	@Autowired
	private BookShopDao bookShopDao;
	
	
	/**
	 * spring hibernate 事物的流程
	 * 1.在方法开始之前
	 * 	1）获取session
	 * 	2）把session和当前线程绑定，这样就可以在Dao中使用SessionFactory的
	 * getCurrentSession()方法来获取Session
	 * 	3）开启事物
	 * 
	 * 2.若方法正常结束,即没有出现异常，则
	 * 	1）提交事物
	 * 	2）使和当前线程绑定的Session接触绑定
	 * 	3）关闭Session
	 * 
	 * 3.若方法出现异常，则：
	 * 	1）回滚事物
	 * 	2）使和当前线程绑定的Session解除绑定
	 * 	3）关闭Session
	 * 
	 * 注意：抛出RunTimeException才回滚事物
	 * 
	 */
	public void purchase(String username, String isbn) {
		int price=bookShopDao.findBookPriceById(isbn);
		bookShopDao.updateBookStock(isbn);
		bookShopDao.updateUserAccount(username, price);
		
		
	}

}

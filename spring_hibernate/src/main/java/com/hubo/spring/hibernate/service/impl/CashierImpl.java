package com.hubo.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubo.spring.hibernate.service.BookShopService;
import com.hubo.spring.hibernate.service.Cashier;

@Service
public class CashierImpl implements Cashier{
	@Autowired
	private BookShopService bookShopService;
	
	public void checkout(String username, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase(username, isbn);
		}
		
	}

}

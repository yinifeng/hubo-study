package com.hubo.spring.hibernate.service;

import java.util.List;

public interface Cashier {
	void checkout(String username,List<String> isbns);
}

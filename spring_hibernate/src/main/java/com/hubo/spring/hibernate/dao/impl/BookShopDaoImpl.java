package com.hubo.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hubo.spring.hibernate.dao.BookShopDao;
import com.hubo.spring.hibernate.exception.BookStockException;
import com.hubo.spring.hibernate.exception.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 此处不使用 HibernateDaoSupport (hibernate4已没有此类)
	 *         HibernateTemplate
	 */
	
	//获取当前线程绑定的session
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public int findBookPriceById(String isbn) {
		String hql="select b.price from Book b where b.isbn=?";
		Query query=getSession().createQuery(hql).setString(0, isbn);
		return (Integer) query.uniqueResult();
	}

	public void updateBookStock(String isbn) {
		//验证书的库存是否充足
		String hql="select b.stock from Book b where b.isbn=?";
		int stock=(Integer) getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		if(stock==0){
			throw new BookStockException("库存不足!!");
		}
		hql="update Book b set b.stock=b.stock-1 where b.isbn=?";
		getSession().createQuery(hql).setString(0, isbn).executeUpdate();
	}

	public void updateUserAccount(String username, int price) {
		//验证账户余额
		String hql="select a.balance from Account a where a.userName=?";
		int balance=(Integer) getSession().createQuery(hql).setString(0, username).uniqueResult();
		
		if(balance<price){
			throw new UserAccountException("账户余额不足！！");
			//throw new Exception("账户余额不足！！");
		}
		
		hql="update Account a set a.balance=a.balance-? where a.userName=?";
		getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();


	}

}

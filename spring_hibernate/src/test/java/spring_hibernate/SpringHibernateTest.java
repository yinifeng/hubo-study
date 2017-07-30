package spring_hibernate;

import java.sql.SQLException;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;

import com.hubo.spring.hibernate.service.BookShopService;
import com.hubo.spring.hibernate.service.Cashier;

public class SpringHibernateTest extends BasicJunit4Test{
	@Resource
	private DataSource dataSource;
	@Resource
	private BookShopService bookShopService;
	@Resource
	private Cashier cashier;
	
	@Test
	public void testDataSource() throws SQLException{
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testPurchase(){
		bookShopService.purchase("tom", "1001");
	}
	
	/**
	 * 买一本成功，买第二本，抛出余额不足异常
	 * 整理回滚事物
	 * 可以设置 事物的传播行为，来建立一个新的事物 ，使可以购买一本成功
	 */
	@Test
	public void testCheckout(){
		cashier.checkout("tom", Arrays.asList("1001","1002"));
	}
}

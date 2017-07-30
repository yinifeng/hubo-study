package com.hubo.jdbc.datasource;



import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 数据库连接池 DataSource  JDK api
 * @author hubo
 * 
 * 目前使用比较多的开源数据库连接池：
 * 1.DBCP
 * 2.C3p0
 * 3.淘宝 ailibab
 *
 */
public class DataSourceTest {
	
	/**
	 * 配置文件配置数据连接
	 * @throws Exception 
	 */
	@Test
	public void testC3p0ConfigFile() throws Exception{
		DataSource dataSource=new ComboPooledDataSource("helloc3p0");
		System.out.println(dataSource.getConnection().getClass());
		
		ComboPooledDataSource cpds=(ComboPooledDataSource) dataSource;
		System.out.println(cpds.getMaxStatements());
		
	}
	
	/**
	 * c3p0数据库连接池
	 * @throws PropertyVetoException
	 * @throws SQLException
	 */
	@Test
	public void testC3p0() throws PropertyVetoException, SQLException{
			ComboPooledDataSource cpds=new ComboPooledDataSource();
			cpds.setUser("demo");
			cpds.setPassword("123456");
			cpds.setJdbcUrl("jdbc:oracle:thin:@hobart:1521:orcl");
			cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
			System.out.println(cpds.getConnection());
		
	}
	
	/**
	 * 1.配置文件中获取数据库连接 properties
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testBasicDataSourceFactory() throws Exception{
		Properties properties=new Properties();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("dbcp.properties");
		properties.load(is);
		DataSource dataSource=BasicDataSourceFactory.createDataSource(properties);
		System.out.println(dataSource.getConnection().getClass());
		
		BasicDataSource basicDataSource=(BasicDataSource) dataSource;
		System.out.println(basicDataSource.getMaxWait());
		
	}
	
	/**
	 * 1.加入jar包
	 * commos-dbcp
	 * 依赖 commons-pool
	 * @throws SQLException 
	 */
	@Test
	public void testDbcp() throws SQLException {
		//DataSource dataSource=new BasicDataSource();
		final BasicDataSource bDataSource=new BasicDataSource();
		//1.指定数据源的必须属性
		bDataSource.setUsername("demo");
		bDataSource.setPassword("123456");
		bDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bDataSource.setUrl("jdbc:oracle:thin:@hobart:1521:orcl");
		//测试
		//System.out.println(bDataSource.getConnection());
		
		//2.指定数据源的可选属性
		//1).指定数据库连接池中初始化连接的个数
		bDataSource.setInitialSize(5);
		
		//2).指定最大的连接数：同一时刻向数据库申请的连接数
		bDataSource.setMaxActive(5);
		
		//3).指定最小的连接数：在数据库连接池中保存的最小空闲连接数
		bDataSource.setMinIdle(2);
		
		//4).等待数据库连接池分配连接的最长时间，单位毫秒数，超出该时间将抛出异常
		bDataSource.setMaxWait(1000*5);
		
		//3.从数据库中获取数据库连接
		Connection con = bDataSource.getConnection();
		System.out.println(con.getClass());
		
		con = bDataSource.getConnection();
		System.out.println(con.getClass());
		
		con = bDataSource.getConnection();
		System.out.println(con.getClass());
		
		con = bDataSource.getConnection();
		System.out.println(con.getClass());
		
		Connection con2 = bDataSource.getConnection();
		System.out.println(">"+con2.getClass());
		
//		Connection con3 = bDataSource.getConnection();
//		System.out.println(">"+con3.getClass());
		
		//新建另外个线程 获取连接
		new Thread(){
			public void run() {
				Connection conn;
				try {
					conn=bDataSource.getConnection();
					System.out.println("另外的线程："+conn.getClass());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			};
		}.start();
		
		//使当前这个线程睡眠 超过5秒就不会释放数据库连接，另外个线程超过等待时间没获取连接就会抛出异常
		try {
			Thread.sleep(4500); 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		con2.close();
		
	}

}

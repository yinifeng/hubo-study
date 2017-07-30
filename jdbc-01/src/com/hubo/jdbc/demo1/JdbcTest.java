package com.hubo.jdbc.demo1;



import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.junit.Test;



public class JdbcTest {
	
	
	@Test
	public void testOracleCon() throws Exception{
		
		System.out.println(JdbcTools.getConnection());
		
	}
	
	/**
	 *  利用ResultSetMetaData 对象 测试通用的查询方法
	 *  ResultSetMetaData 结果集的元数据 记录 结果集 查询列的总数以及 列名
	 *  
	 */
	@Test
	public void testResultMetadata(){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ResultSetMetaData rsd=null;
		
		
		String sql = "select id,name,email,birth from customers where id=?";
		//String sql = "select id,name,email,birth from customers";
		
		try {
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, 2);
			
			rs=ps.executeQuery();
			
			rsd=rs.getMetaData();
			
			Map<String, Object> values=new HashMap<String, Object>();
			List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
			
			while(rs.next()){
				for(int i=0;i<rsd.getColumnCount();i++){
					String strColu=rsd.getColumnLabel(i+1);
					values.put(strColu, rs.getObject(strColu));
					
				}
				list.add(values);
			}
			
			//System.out.println(values);
			//System.out.println(list);
			Class clazz=Customers.class;
			Object obj=clazz.newInstance();
			for(Entry<String, Object> entry:values.entrySet()){
				String fieldName=entry.getKey();
				Object fieldValue=entry.getValue();
				//System.out.println(fieldName+":"+fieldValue);
				ReflectionUtils.setFieldValue(obj, fieldName, fieldValue);
			}
			
			System.out.println(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(rs, ps, con);
		}
		
		
	}
	
	
	
	/**
	 * PreparedStatement
	 * 1.可以设置站位符
	 * 2.防止sql注入
	 * 3.提升sql性能
	 */
	@Test
	public void testPreparedStatement(){
		String sql="insert into customers (name,email,birth) values (?,?,?)" ;
		this.update(sql, "tom","tom@123.com",new Date(new java.util.Date().getTime()));
		//this.update(sql, "tom","tom@123.com");
		
		
		
		
	}
	
	private void update(String sql,Object ... obj){
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);
			
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1, obj[i]);
			}
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, ps, con);
		}
		
	}
	
	
	/**
	 * ResultSet sql查询结果集
	 * @throws Exception 
	 */
	@Test
	public void testResultSet(){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			con = JdbcTools.getConnection();
			st = con.createStatement();
			String sql = "select id,name,email,birth from customers";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String email = rs.getString(3);
				Date date = rs.getDate(4);

				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(date);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(rs, st, con);
		}
		
		
	}
	
	
	@SuppressWarnings("null")
	public void update(String sql) throws Exception{
		Connection con=null;
		Statement statement=null;
		
		try {
			statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(statement!=null){
				try {
					statement.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}finally{
					if(con!=null){
						try {
							con.close();
						} catch (Exception e3) {
							// TODO: handle exception
						}
					}
				}
			}
			
		}
		
		
		
		
	}
	
	@Test
	public void testStatement() throws Exception{
		//1.获取数据库连接
		Connection con=null;
		
		//2.获取Statement
		Statement sta=null;
		try {
			con = this.getConnection2();
			sta = con.createStatement();
			//3.执行sql
			//String sql = "insert into customers (name,email,birth) values ('xyz','xyz@hubo.com','2017-03-21')";
			//String sql="delete from customers where id=1";
			String sql="update customers set name='aaa' where id=2";
			
			sta.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{	
			if(sta!=null){
				try {
					sta.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}finally{
					if(con!=null){
						try {
							con.close();
						} catch (Exception e3) {
							// TODO: handle exception
						}
					}
				}
			}
			
		}
		
		
	}
	
	
	
	@Test
	public void testGetConnection2() throws Exception{
		System.out.println(this.getConnection2());
	}
	
	public Connection getConnection2() throws Exception{
		String driver=null;
		String jdbcUrl=null;
		String user=null;
		String password=null;
		Properties properties=new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(in);
		driver=properties.getProperty("driver");
		jdbcUrl=properties.getProperty("jdbcUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		
		
		Class.forName(driver);
		
		
		return DriverManager.getConnection(jdbcUrl, user, password);
		
		
	}
	
	/**
	 * DriverManager 获取数据库连接
	 * @throws Exception 
	 * 
	 */
	@Test
	public void DriverManager() throws Exception{
		String driverClass=null;
		String url=null;
		String user=null;
		String password=null;
		
		//通过IO流读取类路劲下的配置信息
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		properties.load(in);
		driverClass=properties.getProperty("driver");
		url=properties.getProperty("jdbcUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		
		//DriverManager 代码中有静态代码块注册Driver 所以可以简写
		//DriverManager.registerDriver((Driver)Class.forName(driverClass).newInstance());
		Class.forName(driverClass);
		
		//DriverManage 获取数据连接
		Connection con=DriverManager.getConnection(url, user, password);
		
		System.out.println(con);
		
		
	}
	
	/**
	 * Driver接口获取数据库连接  Connection
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDriver() throws SQLException {
		//创建驱动接口
		Driver driver=new com.mysql.jdbc.Driver();
		//2.创建URL连接
		String url="jdbc:mysql://127.0.0.1:3306/jdbc_01";
		//3.创建加载配置连接数据库 的 用户名和密码
		Properties info=new Properties();
		info.put("user", "root");
		info.put("password", "123");
		
		//获取数据库连接
		Connection con=driver.connect(url, info);
		
		System.out.println(con);
	}
	
	
	/**
	 * 通过配置文件的方式获取数据库连接
	 * @throws Exception 
	 * 
	 */
	public Connection getConnection() throws Exception{
		String driverClass=null;
		String url=null;
		String user=null;
		String password=null;
		
		//通过IO流读取类路劲下的配置信息
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		properties.load(in);
		driverClass=properties.getProperty("driver");
		url=properties.getProperty("jdbcUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");
		
		//全类名 反射获取对象
		Driver driver=(Driver) Class.forName(driverClass).newInstance();
		
		Properties info=new Properties();
		info.put("user", user);
		info.put("password", password);
		
		return driver.connect(url, info);
	
	}
	
	@Test
	public void testGetConnection() throws Exception{
		System.out.println(this.getConnection());
	}

}

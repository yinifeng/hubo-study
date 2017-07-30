package com.hubo.jdbc.demo1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc数据库工具类
 * @author hubo
 * @version 1.1
 *
 */
public class JdbcTools {
	
	private static DataSource dataSource=null;
	static{
		dataSource=new ComboPooledDataSource("helloc3p0");
	}
	
	/**
	 * c3p0数据库连接池获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection createConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	//回滚事物
	public static void rollback(Connection con){
		if(con!=null){
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//提交事物
	public static void commit(Connection con){
		if(con!=null){
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
	}
	
	//开启事物
	public static void beginTx(Connection con){
		if(con!=null){
			try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 可变参数 设置 占位符sql
	 * @param sql
	 * @param args
	 */
	public static void update(String sql,Object...args){
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);
			
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
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
	 * 关闭数据库连接
	 * @return
	 * @throws Exception
	 */
	public static void closeAll(ResultSet rs,Statement st,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/*
	 * 获取数据库连接
	 */
	public static Connection getConnection() throws Exception{
		String driver=null;
		String jdbcUrl=null;
		String user=null;
		String password=null;
		Properties properties=new Properties();
		InputStream in = JdbcTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(in);
		driver=properties.getProperty("driver");
		jdbcUrl=properties.getProperty("jdbcUrl");
		user=properties.getProperty("user");
		password=properties.getProperty("password");

		Class.forName(driver);
		return DriverManager.getConnection(jdbcUrl, user, password);	
	}
}

package com.hubo.jdbc.dbutils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryLoader;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.hubo.jdbc.demo1.Customers;
import com.hubo.jdbc.demo1.JdbcTools;


/**
 * 测试 dbutils 执行sql
 * 利用 QueryRunner 类
 * 执行update  query 方法
 *
 * @author hubo
 *
 */
public class DBUtilsTest {
	
	/**
	 * 加载静态资源文件 sql文件
	 * @throws IOException
	 */
	@Test
	public void testQueryLoader() throws IOException{
		Map<String, String> load = QueryLoader.instance().load("/sql.properties");
		System.out.println(load.get("UPDATE_CUSTOMER"));
	}
	
	
	@Test
	public void testScalarHandler(){
		QueryRunner queryRunner=new QueryRunner();
		String sql="select name from customers where id=?";
		
		Connection con=null;
		
		try {
			con=JdbcTools.createConnection();
			Object name = queryRunner.query(con, sql, new ScalarHandler(), 5);
			System.out.println(name);
			sql="select count(*) from customers";
			Object count = queryRunner.query(con, sql, new ScalarHandler());
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, null, con);
		}
		
	}
	
	@Test
	public void testMapListHandler(){
		QueryRunner queryRunner=new QueryRunner();
		String sql="select id,name,email,birth from customers";
		Connection con=null;
		
		try {
			con=JdbcTools.createConnection();
			List<Map<String, Object>> list = queryRunner.query(con, sql, new MapListHandler());
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, null, con);
		}
	}
	
	@Test
	public void testMapHandler(){
		QueryRunner queryRunner=new QueryRunner();
		String sql="select id,name,email,birth from customers where id=?";
		Connection con=null;
		
		try {
			con=JdbcTools.createConnection();
			Map<String, Object> map = queryRunner.query(con, sql, new MapHandler(), 5);
			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, null, con);
		}
	}
	
	@Test
	public void testBeanListHandler(){
		QueryRunner queryRunner=new QueryRunner();
		String sql="select id,name,email,birth from customers";
		Connection con=null;
		
		try {
			con=JdbcTools.createConnection();
			List<Customers> cList = queryRunner.query(con, sql, new BeanListHandler<Customers>(Customers.class));
			System.out.println(cList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, null, con);
		}
	}
	
	/**
	 * QueryRunner类的query方法
	 */
	@Test
	public void testResultSetHandler(){
		QueryRunner queryRunner=new QueryRunner();
		Connection conn=null;
		String sql="select id,name,email,birth from customers";
		
		
		/*
		 * 2.调用query方法
		 * ResultSetHandler 参数的作用：query方法的返回值直接取决于
		 * ResultSetHandler 的hanle方法的返回值
		 */
		try {
			conn=JdbcTools.createConnection();
			List<Customers> clist = queryRunner.query(conn, sql, new ResultSetHandler<List<Customers>>(){
				@Override
				public List<Customers> handle(ResultSet arg0) throws SQLException {
					// TODO Auto-generated method stub
					List<Customers> list=new ArrayList<Customers>();
					while(arg0.next()){
						int id=arg0.getInt(1);
						String name=arg0.getString(2);
						String email=arg0.getString(3);
						Date date=arg0.getDate(4);
						Customers cs=new Customers(id, name, email, date);
						list.add(cs);
					}
					
					return list;
				}});
			
				System.out.println(clist);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, null, conn);
		}
	}
	
	/**
	 * 测试QueryRunner 的update 方法
	 * 此方法可以执行 update delete insert 语句
	 */
	@Test
	public void testQueryRunnerUpdate() {
		QueryRunner queryRunner=new QueryRunner();
		Connection con=null;
		String sql="delete from customers where id in (?,?)";
		try {
			con=JdbcTools.createConnection();
			queryRunner.update(con, sql, 2,3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, null, con);
		}
		
	}

}

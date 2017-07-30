package com.hubo.jdbc.transacte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.hubo.jdbc.demo1.JdbcTools;


/**
 * jdbc 事物测试
 * @author hubo
 *
 */

public class TransacteTest {

	
	/**
	 * 一个connection 连接才对应一个事物，不同connection执行的sql 之间对应的单独一个事物
	 * 事物与事物之间是不相互影响的   事物 ：隔离性
	 * mysql数库默认事物是关闭的。
	 * 
	 * 1.开启事物
	 * 2.抛异常回滚事物
	 * 3.提交事物
	 * 
	 * 
	 */
	@Test
	public void test1(){
		Connection con=null;
		try {
			// 获取连接
			con=JdbcTools.getConnection();
			//开启事物
			con.setAutoCommit(false);
			//tom账户余额-50
			String sql1="update account set money=money-500 where id=1";
			this.update(sql1,con);
			
			//抛异常
			System.out.println(1/0);
			
			//marry账户余额+500
			sql1="update account set money=money+500 where id=2";
			this.update(sql1,con);
			
			//提交事物
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 回滚事物
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally{
			JdbcTools.closeAll(null, null, con);
		}
		
		
	}

	private void update(String sql1, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql1);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, ps, null);
		}
		
		
	}
	
	
	
	
}

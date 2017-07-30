package com.hubo.jdbc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import com.hubo.jdbc.demo1.JdbcTools;

/**
 * jdbc 测试批处理sql
 * @author hubo
 *
 */
public class BatchTest {
	
	/**
	 * 调用批处理方法
	 * 惊人的速度 666
	 */
	@Test
	public void testPreparedStatementBatch(){
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=JdbcTools.getConnection();
			JdbcTools.beginTx(con);
			sql="insert into customers values (?,?,?,sysdate)";
			ps=con.prepareStatement(sql);
			long start=System.currentTimeMillis();
			for(int i=0;i<100000;i++){
				ps.setInt(1, (i+1));
				ps.setString(2, "tom"+(i+1));
				ps.setString(3, "tom"+(i+1)+"@163.com");
				
				//ps.executeUpdate();
				//先积攒sql 例如 一车一车拉东西，还是一火车拉东西
				ps.addBatch();
				//当积攒了一点sql 那么就执行一次，然后把上次积攒的sql清空
				if((i+1) % 300==0){
					ps.executeBatch();
					ps.clearBatch();
				}
				
			}
			
			//如果执行最后还剩 不超过 300 的sql 最后执行
			//总条数 计算余数不等于0
			if(100000 % 300 !=0){
				ps.executeBatch();
				ps.clearBatch();
			}
			
			
			long end=System.currentTimeMillis();
			System.out.println("time:"+(end-start));
			JdbcTools.commit(con);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JdbcTools.rollback(con);
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, ps, con);
		}
	
		
		
	}
	
	
	
	/**
	 * 8268
	 */
	@Test
	public void testPreparedStatementUpdate(){
		Connection con=null;
		PreparedStatement ps=null;
		String sql=null;
		
		try {
			con=JdbcTools.getConnection();
			JdbcTools.beginTx(con);
			sql="insert into customers values (?,?,?,sysdate)";
			ps=con.prepareStatement(sql);
			long start=System.currentTimeMillis();
			for(int i=0;i<100000;i++){
				ps.setInt(1, (i+1));
				ps.setString(2, "tom"+(i+1));
				ps.setString(3, "tom"+(i+1)+"@163.com");
				
				ps.executeUpdate();
				
			}
			long end=System.currentTimeMillis();
			System.out.println("time:"+(end-start));
			JdbcTools.commit(con);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JdbcTools.rollback(con);
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, ps, con);
		}
	
		
		
	}
	
	
	/**
	 * Statemet批量执行sql
	 * 耗时： 45493
	 *
	 */
	@Test
	public void testStatementBatch() {
		Connection con=null;
		Statement st=null;
		String sql=null;
		//String sql="insert into customers values (?,?,?,sysdate);";
		
		try {
			con=JdbcTools.getConnection();
			System.out.println(con);
			//开启事物
			JdbcTools.beginTx(con);
			st=con.createStatement();
			long start=System.currentTimeMillis();
//			sql="insert into customers(id,name,email,birth) values (1,'tom','tom@163.com',sysdate)";
//			st.executeUpdate(sql);
			for(int i=0;i<100000;i++){
				sql="insert into customers values ("+(i+1)+",'tom"+(i+1)+"','tom"+(i+1)+"@163.com',sysdate)";
				//System.out.println(sql);
				//st.addBatch(sql);
				//st.executeBatch();
				st.executeUpdate(sql);
			}
			long end=System.currentTimeMillis();
			
			
			System.out.println("time:"+(end-start));
			JdbcTools.commit(con);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JdbcTools.rollback(con);
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, st, con);
		}
		
	}

}

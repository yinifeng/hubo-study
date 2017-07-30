package com.hubo.jdbc.callablestatement;

import static org.junit.Assert.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.junit.Test;

import com.hubo.jdbc.demo1.JdbcTools;

public class CallableStatementTest {

	@Test
	public void testCallFunction() {
		Connection con=null;
		CallableStatement cas=null;
		
		try {
			//代返回值的为函数，不代返回值的为存储过程
			String sql="{?=call get_sal(?)}";
			con=JdbcTools.getConnection();
			//System.out.println(con.getClass());
			cas=con.prepareCall(sql);
			//注册out型参数
			cas.registerOutParameter(1, Types.NUMERIC);
			//注册in型参数
			cas.setInt(2, 1002);
			
			//执行
			cas.execute();
			
			//获取返回值
			int result=cas.getInt(1);
			
			System.out.println(result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(null, cas, con);
		}
		
		
	}

}

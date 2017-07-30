package com.hubo.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.hubo.jdbc.demo1.JdbcTools;


/**
 * jdbc 执行dml的通用方法
 * @author hubo
 *
 */
public class Dao {
	
	/**
	 * 执行 insert，update，delete的通用方法
	 * @param sql 语句
	 * @param args 参数
	 */
	public void update(String sql,Object...args){
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			//1.获取数据库连接
			con=JdbcTools.getConnection();
			//2.获取PreparedStatement
			ps=con.prepareStatement(sql);
			
			//3.设置参数占位符
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			
			ps.executeUpdate();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			JdbcTools.closeAll(null, ps, con);
		}
		
	}
	
	/**
	 * 获取一个结果集
	 * @param clazz 对象类型
	 * @param sql 语句
	 * @param args 参数
	 * @return
	 */
	public <T> T get(Class<T> clazz,String sql,Object...args){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		T entitry=null;
		
		try {
			//获取数据库连接
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);
			//设置查询参数
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			
			//获取查询结果集
			rs=ps.executeQuery();
			//获取结果集元数据
			ResultSetMetaData rsd=rs.getMetaData();
			//创建map对象存放结果集数据
			Map<String, Object> map=new HashMap<String, Object>();
			if(rs.next()){
				for(int i=0;i<rsd.getColumnCount();i++){
					String key=rsd.getColumnLabel(i+1);
					Object object = rs.getObject(key);
					map.put(key, object);
				}
			}
			//创建对象
			entitry=clazz.newInstance();
			
			//map 转换javaBean对象
			for(Map.Entry<String, Object> entry:map.entrySet()){
				String propertyName=entry.getKey();
				Object PropertyValue=entry.getValue();
				//利用Apache 工具类转换bean
				BeanUtils.setProperty(entitry, propertyName, PropertyValue);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库
			JdbcTools.closeAll(rs, ps, con);
			
		}

		return entitry;
	}
	
	/**
	 * 获取多行结果集
	 * @param clazz 对象类型
	 * @param sql 语句
	 * @param args 参数
	 * @return
	 */
	public <T> List<T> query(Class<T> clazz,String sql,Object...args){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		T entitry=null;
		List<T> resultList=new ArrayList<T>();
		
		try {
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);
			//填充参数
			if(args!=null){
				for(int i=0;i<args.length;i++){
					ps.setObject(i+1, args[i]);
				}
			}
			
			//获取ResultSet
			rs = ps.executeQuery();
			ResultSetMetaData rsd=rs.getMetaData();
			Map<String, Object> map=null;
			List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
			while(rs.next()){
				map=new HashMap<String, Object>();
				for(int i=0;i<rsd.getColumnCount();i++){
					String key=rsd.getColumnLabel(i+1);
					Object obj=rs.getObject(key);
					map.put(key, obj);
				}
				list.add(map);
			}
			
			//创建对象
			entitry=clazz.newInstance();
			
			if(list.size()>0){
				for(Map<String, Object> m:list){
					for(Map.Entry<String, Object> entry:m.entrySet()){
						String propertyName=entry.getKey();
						Object propertyValue=entry.getValue();
						BeanUtils.setProperty(entitry, propertyName, propertyValue);
					}
					resultList.add(entitry);
				}
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(rs, ps, con);
		}
		return resultList;
	}
	
	/**
	 * 获取一个一行一列的数据
	 * 如：count，max，min...
	 * @param sql 语句
	 * @param args 参数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> E count(String sql,Object...args){
		//Assert.assertNotNull(args);
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		E entitry=null;
		
		try {
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);
			if(args!=null){
				for(int i=0;i<args.length;i++){
					ps.setObject(i+1, args[i]);
				}
			}
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				entitry=(E) rs.getObject(1);
			}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTools.closeAll(rs, ps, con);
		}

		return entitry;
	}
}

package com.hubo.shiro.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthorizingRealm {
	
	//登陆认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//其实这个token 就是 handler中的UsernamePasswordToken 对象
		System.out.println("[FirstRealm] doGetAuthenticationInfo: "+token.hashCode());
		
		//1.把AuthenticationToken对象转换为UsernamePasswordToken 对象
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		//2.从UsernamePasswordToken 中获取表单输入的username
		String username=upToken.getUsername();
		
		//3.调用数据库方法，从数据库查询username对应的记录
		System.out.println("从数据库中获取username: "+username+"所对应的用户信息");
		
		//4.若用户不存在，则可以抛出 AuthenticationException 的子类异常
		if("unknown".equals(username)){
			throw new UnknownAccountException("用户名不存在！");
		}
		
		//5.根据用户信息情况，决定抛出AuthenticationException什么样的子类异常
		if("monster".equals(username)){
			throw new LockedAccountException("用户被锁定！");
		}
		//6.根据用户情况，来构建AuthenticationInfo对象并返回
		//以下信息从数据库获取的。
		//1).principal：认证的实体信息，可以是username，也可以是数据表对应用户的实体类对象
		Object principal=username;
		//2).credentials:密码     CredentialsMatcher 对象比对密码
		Object credentials=null;//"fc1709d0a95a6be30bc5926fdb7f22f4";//123456
		if("admin".equals(username)){
			credentials="038bdaf98f2037b31f1e75b5b4c9b26e";
		}else if("user".equals(username)){
			credentials="098d2c478e9c11555ce2823231e02ec1";
		}
		//3).realmName:当前Realm对象的name。调用父类的getName()方法即可
		String realmName=getName();
		
		//4).盐值  ，这地方以用户名作为盐值   ：
		//为什么要使用盐值？
		//如果两个用户的密码 一样 ，那么MD5加密计算出来的字符串就一样
		//为了保证不一样  就增加盐值做为计算 
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		
		SimpleAuthenticationInfo info=null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
		info=new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		
		return info;
	}

	public static void main(String[] args) {
		String algorithmName="MD5";//加密的算法
		Object source="123456"; //需要加密的密码明文
		Object salt=ByteSource.Util.bytes("user");//盐值
		int hashIterations=1024;//加密的次数
		Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(result);
	}
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("doGetAuthorizationInfo.....授权");
		//1.从PrincipalCollection 中获取登陆用户的信息
		Object principal = arg0.getPrimaryPrincipal();
		
		//2.利用登陆的用户的信息来给用户授予 当前用户的角色或权限（可能需要查询数据库）
		Set<String> roles=new HashSet<String>();
		roles.add("user");//授予user角色
		if("admin".equals(principal)){//如果是管理员，添加管理员角色
			roles.add("admin");
		}
		
		//3.创建SimpleAuthorizationInfo，并设置roles属性
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
		
		//4.返回 SimpleAuthorizationInfo 对象
		return info;
	}

}

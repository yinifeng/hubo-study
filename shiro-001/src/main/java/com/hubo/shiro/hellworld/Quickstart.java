package com.hubo.shiro.hellworld;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {

        // The easiest way to create a Shiro SecurityManager with configured
        // realms, users, roles and permissions is to use the simple INI config.
        // We'll do that by using a factory that can ingest a .ini file and
        // return a SecurityManager instance:

        // Use the shiro.ini file at the root of the classpath
        // (file: and url: prefixes load from files and urls respectively):
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.  That is outside the scope of this simple quickstart, so
        // we'll just do the bare minimum so you can continue to get a feel
        // for things.
        SecurityUtils.setSecurityManager(securityManager);

        // Now that a simple Shiro environment is set up, let's see what you can do:

        // get the currently executing user:
        /**获取当前的Subject，调用SecurityUtils.getSubject() 方法*/
        Subject currentUser = SecurityUtils.getSubject();

        // Do some stuff with a Session (no need for a web or EJB container!!!)
        /**测试使用Session*/
        /**获取Session:调用Subject#getSession()方法*/
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("~~~~~~~~~~~~>Retrieved the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        /**测试当前用户是否已经被认证，即是否已经登录*/
        /**调用Subject 的isAuthenticated()的方法*/
        if (!currentUser.isAuthenticated()) {
        	/**把用户名和密码封装为UsernamePasswordToken对象*/
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            /**rememberMe*/
            token.setRememberMe(true);
            try {
            	/**登录*/
                currentUser.login(token);
            } catch (UnknownAccountException uae) {/**未知的用户名，没有指定的用户 抛出UnknownAccountException 异常*/
                log.info("未知的用户名~~~~>There is no user with username of " + token.getPrincipal());
                return;
            } catch (IncorrectCredentialsException ice) {/**密码错误*/
                log.info("密码错误~~~~>Password for account " + token.getPrincipal() + " was incorrect!");
                return;
            } catch (LockedAccountException lae) {/**账户被锁定，web环境下执行*/
                log.info("账户被锁~~~~~~>The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {/**所有认证异常 异常 的父类*/
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //test a role:
        /**测试是否有某个角色，调用Subject的hasRole 方法*/
        if (currentUser.hasRole("schwartz")) {
            log.info("~~~~~~~>May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level)
        /**测试用户是否具备某个行为，调用Subject 的isPermitted方法*/
        if (currentUser.isPermitted("lightsaber:weild")) {
            log.info("~~~~~~~>You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        /**测试用户是否具备某个行为，如：某个用户可以对张三进行删除的行为*/
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        /**执行登出*/
        currentUser.logout();

        System.exit(0);
    }
}

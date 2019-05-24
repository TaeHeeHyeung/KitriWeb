package com.kitri.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {


    public MyServletContextListener() {
    	System.out.println("MyServletContextListener 객체생성");
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	//(서버가 실행될때 초기에 실행된다.)
    	//Service 객체생성 을 여기서하자
    	//Service 객체 참조변수는 ServletContext의 attribute 안에 넣어준다.
    	System.out.println("MyServletContextListener contextInitialized()호출됨");
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("MyServletContextListener contextDestroyed()호출됨");
    }


	
}

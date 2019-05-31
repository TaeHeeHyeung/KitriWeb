package com.kitri.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MySessionAttributeListener
 *
 */
@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {
	private int loginCnt;

    public MySessionAttributeListener() {
    	
    }


    public void attributeAdded(HttpSessionBindingEvent event)  {
    	String attrName = event.getName();
    	if("loginInfo".equals(attrName)) {
//    		System.out.println("MySessionAttributeListener "+ event.getValue()+"님이 로그인하셨습니다.");
//    		System.out.println("MySessionAttributeListener 로그인된 사용자수 :"+(++loginCnt)+"명");
    	}
    }


    public void attributeRemoved(HttpSessionBindingEvent event)  {
    	String attrName = event.getName();
    	if("loginInfo".equals(attrName)) {
//    		System.out.println("MySessionAttributeListener "+ event.getValue()+"님이 로그아웃하였습니다..");
//    		System.out.println("MySessionAttributeListener 로그인된 사용자수 :"+(--loginCnt)+"명");
    	}
    	
    }


    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	
    }
	
}

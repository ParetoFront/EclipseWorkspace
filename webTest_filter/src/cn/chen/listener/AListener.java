package cn.chen.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AListener
 *
 */
@WebListener
public class AListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

	
    public void contextInitialized(ServletContextEvent evt)  { 
    	//创建map用于存储数据
    	Map<String,Integer> map=new LinkedHashMap<String,Integer>();
    	ServletContext application=evt.getServletContext();
    	application.setAttribute("map", map);
    	
    }
	
}

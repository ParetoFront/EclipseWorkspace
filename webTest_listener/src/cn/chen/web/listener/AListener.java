package cn.chen.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("死之前");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("生之后");
	}

}

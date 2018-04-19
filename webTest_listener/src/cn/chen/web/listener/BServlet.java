package cn.chen.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BServlet implements ServletContextAttributeListener {
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("您向application中添加了属性" + arg0.getName()+"他的值为"+arg0.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub    
		System.out.println("您修改了属性 " + arg0.getName() + "他的原值为 " + arg0.getValue() + "他的新值为  "
				+ arg0.getServletContext().getAttribute(arg0.getName()));
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("您删除了 属性" + arg0.getName());

	}
}

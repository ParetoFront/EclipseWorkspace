package webTest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class myservlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy()...");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig()...");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		// TODO Auto-generated method stub
		return "hello,it is servlet";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()...11111");
		System.out.println(arg0.getInitParameter("p1"));
		Enumeration list=arg0.getInitParameterNames();
		while(list.hasMoreElements()) {
			System.out.println(list.nextElement());
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service()...");
	}

}

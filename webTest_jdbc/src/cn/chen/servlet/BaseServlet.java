package cn.chen.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		//查询用户想要调用的method
		String methodName=req.getParameter("method");
		if(methodName==null||methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method名");
		}
		//校验本servlet是否含有请求的method
		Class c=this.getClass();//得到当前类的class对象
		Method method=null;
		try {
			method=c.getMethod(methodName,ServletRequest.class,ServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您调用的方法不存在");
		} 
		//正式开始调用method
		try {
			method.invoke(this, req,resp);
		} catch (Exception e) {
			throw new RuntimeException("您调用的方法内部出错 了");
		}
	}
}

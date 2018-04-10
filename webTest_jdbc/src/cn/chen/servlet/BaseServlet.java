package cn.chen.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询用户想要调用的method
		String methodName=req.getParameter("method");
		if(methodName==null||methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method名");
		}
		//校验本servlet是否含有请求的method
		Class c=this.getClass();//得到当前类的class对象
		Method method=null;
		try {
			method=c.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您调用的方法不存在");
		} 
		//正式开始调用method
		try {
			String result =(String) method.invoke(this, req,resp);
			//获取请求处理后的返回值，帮他进行转发或者重定向
			//若返回值为空，则什么也不做
			//查看返回的字符串中是否包含冒号，若没有，表示转发，
			//若有，使用冒号分割字符串，得到前缀和后缀
			//若前缀为f，表示转发，若前缀为r，表示重定向，后缀为转发或重定向的路径
			if(result==null|result.trim().isEmpty()) {
				return;
			}
			if(result.contains(":")) {
				int index=result.indexOf(":");
				String pre=result.substring(0, index);
				String after=result.substring(index+1);
				if(pre.equalsIgnoreCase("r")) {
					resp.sendRedirect(req.getContextPath()+after);
				}else if(pre.equalsIgnoreCase("f")) {
					req.getRequestDispatcher(after).forward(req, resp);
				}else {
					throw new RuntimeException("您指定的操作 "+pre+"当前版本还不支持");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("您调用的方法内部出错 了");
		}
	}
}

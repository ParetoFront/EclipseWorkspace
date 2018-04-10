package cn.chen.servlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/BServlet")
public class BServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public String fun1(ServletRequest req,ServletResponse resp) {
		System.out.println("返回值没有冒号，表示转发");
		return "/index.jsp";
	}
	public String fun2(ServletRequest req,ServletResponse resp) {
		System.out.println("返回值有冒号，前缀为f，表示转发");
		return "f:/index.jsp";
	}
	public String fun3(ServletRequest req,ServletResponse resp) {
		System.out.println("返回值有冒号，前缀为r，表示重定向");
		return "r:/index.jsp";
	}

}
package cn.chen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
		//获取参数，用来识别用户想请求得方法
		//通过反射调用方法，提高程序的灵活性
@WebServlet("/AServlet")
public class AServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public void addUser(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("addUser");
	}
	public void editUser(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("editUser");
	}
	public void deleteUser(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("deleteUser");
	}

}
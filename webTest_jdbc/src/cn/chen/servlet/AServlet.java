package cn.chen.servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		//获取参数，用来识别用户想请求得方法
		//通过反射调用方法，提高程序的灵活性
@WebServlet("/AServlet")
public class AServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("addUser");
	}
	public void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("editUser");
	}
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("deleteUser");
	}

}
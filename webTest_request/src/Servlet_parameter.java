

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_parameter
 */
@WebServlet("/Servlet_parameter")
public class Servlet_parameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET:  "+request.getParameter("xxx"));
		System.out.println("GET:  "+request.getParameter("yyy"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST:  "+request.getParameter("username"));
		System.out.println("POST:  "+request.getParameter("password"));
		System.out.println("POST:  "+Arrays.toString(request.getParameterValues("hobby")));
	}

}

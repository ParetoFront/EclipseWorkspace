package cn.chen.book.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.chen.book.service.BookService;
import cn.itcast.servlet.BaseServlet;


@WebServlet("/BookServlet")
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService=new BookService();
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("bookList", bookService.findAll());
		return "f:/show.jsp";
	}
	public String findByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("category");
		int value=Integer.parseInt(category);
		request.setAttribute("bookList", bookService.findByCategory(value));
		return "f:/show.jsp";
	}
}

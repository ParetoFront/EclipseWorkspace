package cn.ifklyj.bookstore.book.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ifklyj.bookstore.book.domain.Book;
import cn.ifklyj.bookstore.book.service.BookService;
import cn.ifklyj.bookstore.category.domain.Category;
import cn.ifklyj.bookstore.category.service.CategoryService;
import cn.itcast.servlet.BaseServlet;

@WebServlet("/AdminBookServlet")
public class AdminBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService=new BookService();
	CategoryService categoryService=new CategoryService();
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("bookList", bookService.findAll());
		return "f:/adminjsps/admin/book/list.jsp";
	}
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid=request.getParameter("bid");
		request.setAttribute("book", bookService.load(bid));
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/desc.jsp";
	}
	public String addPre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//添加图书的准备工作，查询所有分类，保存到request，转发到add.jsp,供编辑新图书时选择分类用
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/book/add.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bid=request.getParameter("bid");
		bookService.delete(bid);
		return findAll(request,response);
	}
	/*
	 * 修改图书时，封装数据时，需要把页面的有一个隐藏字段把image传递过来，否则图片会丢失
	 */
	public String mod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Book book=new Book();
			BeanUtils.populate(book, request.getParameterMap());
			Category category=new Category();
			BeanUtils.populate(category, request.getParameterMap());
			book.setCategory(category);
			bookService.mod(book);
			return findAll(request,response);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
	}
}
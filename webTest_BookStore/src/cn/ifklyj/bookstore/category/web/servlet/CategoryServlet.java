package cn.ifklyj.bookstore.category.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ifklyj.bookstore.category.domain.Category;
import cn.ifklyj.bookstore.category.service.CategoryService;
import cn.itcast.servlet.BaseServlet;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryService();

	public String findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> list = categoryService.findAll();
		req.setAttribute("categoryList", list);
		return "f:/jsps/left.jsp";
	}

}
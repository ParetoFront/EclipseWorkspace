package cn.ifklyj.bookstore.category.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ifklyj.bookstore.category.domain.Category;
import cn.ifklyj.bookstore.category.service.CategoryService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

@WebServlet("/AdminCategoryServlet")
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	CategoryService categoryService=new CategoryService();
	
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("categoryList", categoryService.findAll());
		return "f:/adminjsps/admin/category/list.jsp";
	}
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		Category category=new Category();
		BeanUtils.populate(category, request.getParameterMap());
		category.setCid(CommonUtils.uuid());
		categoryService.add(category);
		return findAll(request,response);  //添加分类之后直接跳转findAll，实现展示最新的分类列表
	}
	/*
	 * 删除分类时需要注意的问题是：如果该分类下有图书，则不允许删除，抛出异常
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=request.getParameter("cid");
		try {
			categoryService.delete(cid);
			return findAll(request,response);
		}catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "f:/adminjsps/msg.jsp";
		}
		
	}
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid=request.getParameter("cid");
		request.setAttribute("modCategory",categoryService.findByCid(cid));
		return "f:/adminjsps/admin/category/mod.jsp";
	}
	public String mod(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		Category category=new Category();
		BeanUtils.populate(category, request.getParameterMap());
		categoryService.mod(category);
		return findAll(request,response);
	}
}
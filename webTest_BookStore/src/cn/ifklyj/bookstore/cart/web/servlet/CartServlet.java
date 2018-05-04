package cn.ifklyj.bookstore.cart.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ifklyj.bookstore.book.domain.Book;
import cn.ifklyj.bookstore.book.service.BookService;
import cn.ifklyj.bookstore.cart.domain.Cart;
import cn.ifklyj.bookstore.cart.domain.CartItem;
import cn.itcast.servlet.BaseServlet;

@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获得购物车（在登陆成功时已为用户创建）
		Cart cart=(Cart) req.getSession().getAttribute("cart");
		//得到图书浏览界面提交的表单，形成item加入cart
		String bid=req.getParameter("bid");
		Book book=new BookService().load(bid);  //由bid取得book对象
		int count=Integer.parseInt(req.getParameter("count"));
		CartItem cartItem=new CartItem();
		cartItem.setBook(book);
		cartItem.setCount(count);
		cart.add(cartItem);
		req.getSession().setAttribute("cart", cart);
		return "f:/jsps/cart/list.jsp";
	}
	public String delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cart cart=(Cart) req.getSession().getAttribute("cart");
		String bid=req.getParameter("bid");
		cart.delete(bid);
		return "f:/jsps/cart/list.jsp";
	}
	public String clear(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cart cart=(Cart) req.getSession().getAttribute("cart");
		cart.clear();
		return "f:/jsps/cart/list.jsp";
	}
	public String update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		return "f:/jsps/cart/list.jsp";
	}
	
}
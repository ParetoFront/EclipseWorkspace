package cn.ifklyj.bookstore.order.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ifklyj.bookstore.cart.domain.Cart;
import cn.ifklyj.bookstore.cart.domain.CartItem;
import cn.ifklyj.bookstore.order.domain.Order;
import cn.ifklyj.bookstore.order.domain.OrderItem;
import cn.ifklyj.bookstore.order.service.OrderException;
import cn.ifklyj.bookstore.order.service.OrderService;
import cn.ifklyj.bookstore.user.domain.User;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService=new OrderService();
	
	/*
	 * add方法：将购物车内容添加到订单
	 * 1.生成订单：订单有购物车生成，从session中获取cart，由cart生成order
	 * 2.清空购物车
	 * 3.调用service的add方法
	 * 4.保存生成的订单，转发到order/desc.jsp
	 */
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cart cart =(Cart) req.getSession().getAttribute("cart");
		//创建订单
		Order order=new Order();
		//用uuid补全oid，并补全ordertime
		order.setOid(CommonUtils.uuid());
		order.setOrdertime(new Date());
		order.setState(1);
		User user=(User) req.getSession().getAttribute("session_user");
		order.setOwner(user);
		order.setTotal(cart.getTotal());
		//订单的地址暂不设置，在用户选择发货时填写地址
		//遍历Cart中的CartItem，分别生成OrderItem，将其写入Order
		List<OrderItem> orderItemList=new ArrayList<OrderItem>();  //创建条目集合，条目添加到集合从完毕后。就将集合添加到订单中
		for(CartItem cartItem:cart.getCartItems()) {
			OrderItem orderItem=new OrderItem();  //新建订单条目
			orderItem.setIid(CommonUtils.uuid());  //条目id
			orderItem.setCount(cartItem.getCount());//条目的数量
			orderItem.setBook(cartItem.getBook()); //条目对应的书本
			orderItem.setSubtotal(cartItem.getSubTotal()); //条目的小计
			orderItem.setOrder(order);   //条目所属的订单
			
			orderItemList.add(orderItem);  //将条目添加到条目集合中
		}
		order.setOrderItemList(orderItemList);  //将条目集合添加到订单中
		cart.clear();  //生成订单后清空购物车
		orderService.add(order);
		req.setAttribute("order", order);
		return "f:/jsps/order/desc.jsp";
		
	}
	//显示当前用户所有订单
	//通过session获取用户id，根据uid查询订单，并把订单列表保存到request域中
	public String myOrders(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user=(User) req.getSession().getAttribute("session_user");
		List<Order> orderList=orderService.myOrders(user.getUid());
		req.setAttribute("orderList", orderList);
		return "f:/jsps/order/list.jsp";
	}
	//在订单列表页面，点击付款后，通过oid获取order，并转发的desc.jsp显示订单详情页
	public String load(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Order order=orderService.load(req.getParameter("oid"));
		req.setAttribute("order", order);
		return "f:jsps/order/desc.jsp";
	}
	public String confirm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String oid=req.getParameter("oid");
		try {
			orderService.confirm(oid);
			req.setAttribute("msg", "确认收货，交易成功！");
		} catch (OrderException e) {
			req.setAttribute("msg", e.getMessage());
		}
		return "f:/jsps/msg.jsp";
	}
}
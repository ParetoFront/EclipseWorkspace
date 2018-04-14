package cn.chen.cstm.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.chen.cstm.domain.Customer;
import cn.chen.cstm.service.CustomerService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService=new CustomerService();
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IllegalAccessException, Exception {
		//将数据封装至customer
		Customer customer =new Customer();
		BeanUtils.populate(customer,request.getParameterMap());
		customer.setCid(CommonUtils.uuid());
		//调用service层
		customerService.add(customer);
		request.setAttribute("msg", "恭喜，添加成功");
		return "f:/msg.jsp";
	}
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<Customer> list=customerService.findAll();
		request.setAttribute("cstmList", list);
		return "f:/list.jsp";
	}
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String cid=request.getParameter("cid");
		//根据cid从数据库中获取customer对象
		Customer customer=customerService.load(cid);
		request.setAttribute("cstm", customer);
		return "f:/edit.jsp";
	}
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception{
		Customer customer=new Customer();
		BeanUtils.populate(customer,request.getParameterMap());
		customerService.edit(customer);
		request.setAttribute("msg", "恭喜，编辑成功");
		return "f:/msg.jsp";
		
	}
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception{
		Customer criteria=new Customer();
		BeanUtils.populate(criteria,request.getParameterMap());
		List<Customer> cstmList=customerService.query(criteria);
		request.setAttribute("cstmList", cstmList);
		return "f:/list.jsp";
	}
}

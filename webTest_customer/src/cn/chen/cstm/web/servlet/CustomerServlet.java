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
import cn.chen.cstm.domain.PageBean;
import cn.chen.cstm.service.CustomerService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerService();

	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, IllegalAccessException, Exception {
		// 将数据封装至customer
		Customer customer = new Customer();
		BeanUtils.populate(customer, request.getParameterMap());
		customer.setCid(CommonUtils.uuid());
		// 调用service层
		customerService.add(customer);
		request.setAttribute("msg", "恭喜，添加成功");
		return "f:/msg.jsp";
	}

	/**
	 * 1.获取页面传递的pc 
	 * 2.给定ps值 
	 * 3.使用pc值和ps值调用service方法，得到pagebean，保存到request域
	 * 4.转发到list.jsp
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pc=getPc(request);
		int ps=10;
		PageBean<Customer> pb=customerService.findAll(pc,ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		return "f:/list.jsp";
	}
	
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		// 根据cid从数据库中获取customer对象
		Customer customer = customerService.load(cid);
		request.setAttribute("cstm", customer);
		return "f:/edit.jsp";
	}

	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		Customer customer = new Customer();
		BeanUtils.populate(customer, request.getParameterMap());
		customerService.edit(customer);
		request.setAttribute("msg", "恭喜，编辑成功");
		return "f:/msg.jsp";

	}

	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {
		/*
		 * 0.封装条件数据
		 * 1.得到pc
		 * 2.给定ps
		 * 3.使用pc、ps、推荐对象调用service，得到pagebean
		 * 4.将pagebean保存到request
		 */
		
		Customer criteria=new Customer();
		BeanUtils.populate(criteria, request.getParameterMap());
		//处理get请求的编码问题
		criteria=encoding(criteria);
		
		int pc=getPc(request);
		int ps=10;
		PageBean<Customer> pb=customerService.query(criteria,ps,pc);
		//将url保存到pb
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		return "f:/list.jsp";
	}
	
	private int getPc(HttpServletRequest request) {
		//这里pc的值来源于list.jsp页面的${pc=i }等定义pc值的代码，也就是说，pc的值不由servlet提供，而是直接取自page
		String value=request.getParameter("pc");
		if(value==null||value.trim().isEmpty()) {
			return 1;
		}
		//parameter值均为String，转为int
		return Integer.parseInt(value);
	}
	//处理get请求方式的编码问题
	private Customer encoding(Customer criteria) throws Exception {
		String cname=criteria.getCname();
		String gender=criteria.getGender();
		String cellphone=criteria.getCellphone();
		String email=criteria.getEmail();
		if(cname!=null&&!cname.trim().isEmpty()) {
			cname=new String(cname.getBytes("ISO-8859-1"),"utf-8");
			criteria.setCname(cname);
		}
		if(gender!=null&&!gender.trim().isEmpty()) {
			gender=new String(gender.getBytes("ISO-8859-1"),"utf-8");
			criteria.setGender(gender);
		}
		if(cellphone!=null&&!cellphone.trim().isEmpty()) {
			cellphone=new String(cellphone.getBytes("ISO-8859-1"),"utf-8");
			criteria.setCellphone(cellphone);
		}
		if(email!=null&&!email.trim().isEmpty()) {
			email=new String(email.getBytes("ISO-8859-1"),"utf-8");
			criteria.setEmail(email);
		}
		return criteria;
	}
	//构造get方式所需的url
	private String getUrl(HttpServletRequest request) {
		String contextPath=request.getContextPath();
		String servletPath=request.getServletPath();
		String queryString=request.getQueryString();
		//抛弃url中pc参数的部分
		if(queryString.contains("&pc=")) {
			int index=queryString.lastIndexOf("&pc=");
			queryString=queryString.substring(0, index);
		}
		return contextPath+servletPath+"?"+queryString;
	}
}

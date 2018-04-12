package cn.chen.cstm.web.servlet;

import cn.chen.cstm.dao.CustomerDao;
import cn.chen.cstm.domain.Customer;
import cn.chen.cstm.service.CustomerService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
//	private CustomerService customerService=new CustomerService();
	private CustomerDao customerDao=new CustomerDao();
	/**
	 * @author cky
	 * 1.封装表单数据到Customer对象
	 * 2.补全cid，用uuid生成cid
	 * 3.调用service.add
	 * 4.向request域中保存成功信息
	 * 5.转发到msg.jsp
	 */

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customer.setCid(CommonUtils.uuid());
		customerDao.add(customer);
		request.setAttribute("msg", "添加客户成功！");
		return "f:/msg.jsp";
	}

}

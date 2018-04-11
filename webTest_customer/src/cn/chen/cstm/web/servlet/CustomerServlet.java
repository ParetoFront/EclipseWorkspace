package cn.chen.cstm.web.servlet;

import javax.servlet.annotation.WebServlet;

import cn.chen.cstm.service.CustomerService;
import cn.itcast.servlet.BaseServlet;


@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService customerService=new CustomerService();
}

package cn.chen.cstm.service;

import cn.chen.cstm.dao.CustomerDao;
import cn.chen.cstm.domain.Customer;

public class CustomerService {
	private CustomerDao customerDao=new CustomerDao();
	public void add(Customer c) {
		customerDao.add(c);
	}
}

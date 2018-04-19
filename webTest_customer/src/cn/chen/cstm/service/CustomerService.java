package cn.chen.cstm.service;

import java.util.List;

import cn.chen.cstm.dao.CustomerDao;
import cn.chen.cstm.domain.Customer;
import cn.chen.cstm.domain.PageBean;

public class CustomerService {
	private CustomerDao customerDao=new CustomerDao();
	public void add(Customer c) {
		customerDao.add(c);
	}
	public PageBean<Customer> findAll(int pc,int ps) {
		return customerDao.findAll(pc,ps);
	}
	public Customer load(String cid) {
		return customerDao.load(cid);
		
	}
	public void edit(Customer customer) {
		customerDao.edit(customer);
	}
	public void delete(String cid) {
		customerDao.delete(cid);
	}
	public PageBean<Customer> query(Customer criteria, int ps, int pc) {
		return customerDao.query(criteria,ps,pc);
	}
	
}

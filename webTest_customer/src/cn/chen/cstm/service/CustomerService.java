package cn.chen.cstm.service;

import java.util.List;

import cn.chen.cstm.dao.CustomerDao;
import cn.chen.cstm.domain.Customer;

public class CustomerService {
	private CustomerDao customerDao=new CustomerDao();
	public void add(Customer c) {
		customerDao.add(c);
	}
	public List<Customer> findAll() {
		return customerDao.findAll();
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
	public List<Customer> query(Customer criteria) {
		return customerDao.query(criteria);
	}
}

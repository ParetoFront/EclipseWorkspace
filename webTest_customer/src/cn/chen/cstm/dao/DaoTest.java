package cn.chen.cstm.dao;

import org.junit.Test;

import cn.chen.cstm.domain.Customer;
import cn.itcast.commons.CommonUtils;

public class DaoTest {
	private CustomerDao dao=new CustomerDao();
	Customer c=new Customer("11111","mike","男","1994","1312222","qqmail","hello");
	@Test
	public void fun1() {
		c.setCid(CommonUtils.uuid());
		dao.add(c);
	}
}

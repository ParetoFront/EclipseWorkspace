package cn.chen.cstm.dao;

import org.junit.Test;

import cn.chen.cstm.domain.Customer;
import cn.itcast.commons.CommonUtils;

public class DaoTest {
	@Test
	public void fun() {
		CustomerDao dao=new CustomerDao();
		for(int i=0;i<=300;i++) {
			Customer c=new Customer();
			c.setCid(CommonUtils.uuid());
			c.setCname("cstm_"+i);
			c.setBirthday("2018-4-14");
			c.setGender(i%2==0?"男":"女");
			c.setCellphone("131"+i);
			c.setEmail("cstm_"+i+"@qq.com");
			c.setDescription("我是客户 "+i+" 号");
			dao.add(c);
		}
	}
}

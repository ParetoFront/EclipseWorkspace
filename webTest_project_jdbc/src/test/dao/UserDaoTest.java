package test.dao;

import org.junit.Test;

import cn.chen.user.dao.UserDaoImpl;
import cn.chen.user.domain.User;

public class UserDaoTest {
	@Test
	public void testFindUserByUsername() {
		UserDaoImpl userdao=new UserDaoImpl();
		User user=userdao.findByUsername("李四");
		System.out.println(user.getUsername());
	}
	@Test
	public void testAdd() {
		UserDaoImpl userDao=new UserDaoImpl();
		User user=new User();
		user.setUsername("李四");
		user.setPassword("mima");
		userDao.add(user);
	}
}

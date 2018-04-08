package test.dao;

import org.junit.Test;

import cn.chen.user.dao.UserDao;
import cn.chen.user.domain.User;

public class UserDaoTest {
	@Test
	public void testFindUserByUsername() {
		UserDao userdao=new UserDao();
		User user=userdao.findByUsername("李四");
		System.out.println(user.getUsername());
	}
	@Test
	public void testAdd() {
		UserDao userDao=new UserDao();
		User user=new User();
		user.setUsername("李四");
		user.setPassword("mima");
		userDao.add(user);
	}
}

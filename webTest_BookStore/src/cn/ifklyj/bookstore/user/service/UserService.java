package cn.ifklyj.bookstore.user.service;


import cn.ifklyj.bookstore.user.dao.UserDao;
import cn.ifklyj.bookstore.user.domain.User;

public class UserService {
	private UserDao userDao=new UserDao();
	public void regist(User form) throws UserException {
		//校验用户名
		User user=userDao.findByUsername(form.getUsername());
		if(user!=null) throw new UserException("用户名已被注册");
		//校验email
		user=userDao.findByEmail(form.getEmail());
		if(user!=null) throw new UserException("邮箱已被注册");
		
		userDao.add(form);
	}
}

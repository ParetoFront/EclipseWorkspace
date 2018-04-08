package cn.chen.user.service;

import cn.chen.user.dao.DaoFactory;
import cn.chen.user.dao.UserDao;
import cn.chen.user.domain.User;

//user的业务逻辑层
public class UserService {
	//调用dao层的功能
	private UserDao userDao=DaoFactory.getUserDao();
	public void regist(User form) throws UserException {
		//先查询是否已存在用户
		User ifuser=userDao.findByUsername(form.getUsername());
		if(ifuser!=null) {
			throw new UserException("抱歉，用户名"+form.getUsername()+" 已被注册了");
		}
		userDao.add(form);
	}
	public  User login(User form) throws UserException {
		User user=userDao.findByUsername(form.getUsername());
		if(user==null) {
			throw new UserException("用户名不存在！");
		}
		if(!form.getPassword().equals(user.getPassword())) {
			throw new UserException("密码错误");
		}
		return user;
	}
}

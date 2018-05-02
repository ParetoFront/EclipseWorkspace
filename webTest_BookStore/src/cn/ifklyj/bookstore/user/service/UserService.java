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
	public void active(String code) throws UserException {
		User user=userDao.findByCode(code);
		if(user==null) throw new UserException("激活码无效");
		if(user.isState()==true) throw new UserException("您的账户已经激活");
		//校验完成，激活码有效，则修改用户的激活状态
		userDao.updateState(user.getUid(), true);
		
	}
	public User login(User form) throws UserException {
		String username=form.getUsername();
		User user=userDao.findByUsername(username);
		if(user==null) throw new UserException("您尚未注册该用户名！");
		if(!user.getPassword().equals(form.getPassword())) throw new UserException("您的密码错误!");
		if(!user.isState()) throw new UserException("您的账户尚未激活，请到邮箱中查询激活邮件进行激活！");
		return user;
	}
}

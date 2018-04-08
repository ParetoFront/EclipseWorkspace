package cn.chen.user.dao;

import cn.chen.user.domain.User;

public interface UserDao {
	public User findByUsername(String username);
	public void add(User user);
}

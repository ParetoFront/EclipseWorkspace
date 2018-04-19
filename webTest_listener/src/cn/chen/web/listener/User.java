package cn.chen.web.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
	private String username;
	private String password;
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("session添加了该对象");
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("session移除了该对象");
	}
	
}

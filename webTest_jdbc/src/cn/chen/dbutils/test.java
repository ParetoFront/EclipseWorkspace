package cn.chen.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import cn.chen.dbutils.DBUtils.RsHandler;
import cn.chen.jdbcUtils.jdbcUtils2;
import cn.itcast.jdbc.JdbcUtils;



public class test {
	@Test
	public void fun1() {
		User u = new User("mary", "mima123", 27, 3300);
		addUser(u);
	}
	@Test
	public void fun2() {
		User user=load("mike");
		System.out.println(user);
	}
	public void addUser(User user) {
		DBUtils dbu = new DBUtils(jdbcUtils2.getDataSource());
		//给出sql语句
		String sql = "insert into users values(?,?,?,?)";
		//给出参数
		Object[] params = { user.getUsername(), user.getPassword(), user.getAge(), user.getSalary() };
		
		dbu.update(sql, params);
	}
	public User load(String username) {
		DBUtils dbu=new DBUtils(jdbcUtils2.getDataSource());
		String sql="select * from users where username=?";
		Object[] params= {username};
		//实现RsHandler接口
		RsHandler<User> rh=new RsHandler<User>() {
			public User handle(ResultSet rs) throws SQLException{
				if(!rs.next()) return null;
				User user=new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSalary(rs.getInt("salary"));
				return user;
			}
		};
		return (User) dbu.query(sql, rh, params);
	}
}

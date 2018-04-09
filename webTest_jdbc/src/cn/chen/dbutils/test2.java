package cn.chen.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.itcast.jdbc.JdbcUtils;

public class test2 {
	@Test
	public void fun1() throws SQLException {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql="insert into users values(?,?,?,?)";
		Object[] params= {"jack","mima123",33,4000};
		qr.update(sql,params);
	}
	@Test
	public void fun2() throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from users where username=?";
		Object[] params= {"mike"};
		User user=qr.query(sql, new BeanHandler<User>(User.class),params);
		System.out.println(user);
		
	}
	@Test
	public void fun3() throws SQLException {
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select * from users";
		System.out.println(qr.query(sql, new BeanListHandler<>(User.class)));
	}
}

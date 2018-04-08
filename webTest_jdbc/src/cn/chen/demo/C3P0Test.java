package cn.chen.demo;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author 24613
 * c3p0使用
 */
public class C3P0Test {
	@Test
	public void fun1() throws Exception {
		ComboPooledDataSource  dataSource=new ComboPooledDataSource();
		
		//对池进行四大参数配置
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb_1");
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		
		dataSource.setAcquireIncrement(5);
		dataSource.setInitialPoolSize(20);
		
		Connection con=dataSource.getConnection();
		System.out.println(con);
		con.close();
	}
	@Test
	public void fun2() throws Exception {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		Connection con=dataSource.getConnection();
		System.out.println(con);
		con.close();
	}
	@Test
	public void fun3() throws Exception {
		ComboPooledDataSource dataSource=new ComboPooledDataSource("myConfig");
		Connection con=dataSource.getConnection();
		System.out.println(con);
		con.close();
	}
}

package cn.chen.demo;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;


public class PoolTest {
	public static void main(String[] args) throws Exception {
		PoolTest ss=new PoolTest();
		ss.fun1();
	}
	public void fun1() throws Exception {
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/mydb_1");
		datasource.setUsername("root");
		datasource.setPassword("1234");
		
		datasource.setMaxActive(20);
		datasource.setMinIdle(3);
		datasource.setMaxWait(1000);
		
		Connection con=(Connection) datasource.getConnection();
		System.out.println(con.getClass().getName());
		con.close();
	}
}

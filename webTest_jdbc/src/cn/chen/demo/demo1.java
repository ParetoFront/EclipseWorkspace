package cn.chen.demo;


import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import cn.chen.jdbcUtils.jdbcUtils1;

public class demo1 {
	@Test
	public void fun1() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mydatabase_1";
		String username="root";
		String password="1234";
		Connection con=(Connection) DriverManager.getConnection(url,username,password);
		//实现增删改查
		//通过connection创建statement
		Statement stmt=(Statement) con.createStatement();
		String sql="insert into stu values('0003','wangwu',88,'male')";
		int m=stmt.executeUpdate(sql);
		System.out.println(m);
	}
	@Test
	public void fun2() throws Exception {
		String url="jdbc:mysql://localhost:3306/mydatabase_1";
		String name="root";
		String password="123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection(url,name,password);
		Statement stmt=(Statement) con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from emp");
		int cc=rs.getMetaData().getColumnCount();
		rs.next();
		while(rs.next()) {	
			for(int i=1;i<=cc;i++) {
				System.out.print(rs.getString(i));
				if(i<cc) System.out.print(",");
			}
			System.out.println();
		}
		rs.close();
		stmt.close();
		con.close();
	}
	@Test
	public void fun3() throws Exception {
		Connection con=(Connection) jdbcUtils1.getConnection();
		System.out.println(con);
	}
}

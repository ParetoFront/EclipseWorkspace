package cn.chen.demo;

import java.sql.Connection;

import cn.chen.jdbcUtils.jdbcUtils1;

public class IsolationTest {
	public static void main(String[] args) throws Exception {
		Connection con=jdbcUtils1.getConnection();
		con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	}
}
 
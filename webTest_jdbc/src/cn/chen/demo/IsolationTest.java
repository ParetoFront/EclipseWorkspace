package cn.chen.demo;

import java.sql.Connection;

public class IsolationTest {
	public static void main(String[] args) throws Exception {
		Connection con=JdbcUtils.getConnection();
		con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	}
}
 
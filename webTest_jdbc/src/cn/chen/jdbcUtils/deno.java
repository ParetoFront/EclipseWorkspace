package cn.chen.jdbcUtils;

import java.sql.SQLException;

import org.junit.Test;

public class deno {
	private AccountDao dao = new AccountDao();
	@Test
	public void fun1() throws SQLException {
		try {
			jdbcUtils3.beginTransaction();
			dao.update("mike", 999);
			dao.update("mary", 5555);
			jdbcUtils3.committransaction();
		} catch (SQLException e) {
			try {
				jdbcUtils3.rollbackTransaction();
			}catch(SQLException ee) {
				throw e;
			}
		}
	}
}

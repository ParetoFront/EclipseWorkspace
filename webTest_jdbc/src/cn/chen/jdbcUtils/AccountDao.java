package cn.chen.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public static void update(String name,int salary) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="update users set salary=salary+? where name=?";
		Object[] params= {"mike",9999};
		//我们需要自己提供连接，保证多次update使用的是同一个连接，防止出错
		//这要求提供连接的方法能够保证只提供一个相同的连接，jdbcUtils3实现了这一功能
		Connection con=jdbcUtils3.getConnection();
		qr.update(con,sql,params);
	}
}

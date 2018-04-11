package cn.chen.jdbcUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public static void update(String name,int salary) throws SQLException {
//		QueryRunner qr=new QueryRunner();
//		String sql="update users set salary=salary+? where name=?";
//		Object[] params= {"mike",9999};
//		//我们需要自己提供连接，保证多次update使用的是同一个连接，防止出错
//		//这要求提供连接的方法能够保证只提供一个相同的连接，jdbcUtils3实现了这一功能
//		Connection con=jdbcUtils3.getConnection();
//		qr.update(con,sql,params);
//		jdbcUtils3.releaseConnection(con);  //由release方法来判断是否可以关闭该连接
		
		//使用TxQueryRunner，进一步将get和release封装到queryrunner中
		QueryRunner qr=new TxQueryRunner();
		String sql="update users set salary=salary+? where username=?";
		Object[] params= {salary,name};

		qr.update(sql,params);  //在内部它会自动获取连接、释放等，详见TxQueryRunner内部代码

	}
}

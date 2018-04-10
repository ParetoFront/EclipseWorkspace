package cn.chen.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//jdbcUtils3旨在实现事务的控制
public class jdbcUtils3 {
	// 创建连接池，需要c3p0配置文件的支持
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//事务专用连接
	private static Connection con=null;
	//开启一个事务，为con赋值，并且能让commit和rollback操作获取到
	public static void beginTransaction() throws SQLException {
		//防止有人连续调用begin
		if(con!=null) throw new SQLException("您已经开始了一个事务");
		con=getConnection();
		con.setAutoCommit(false);
	}

	// 提交事务，需要获取begin提供的connection，然后调用commit
	public static void committransaction() throws SQLException {
		if(con==null) throw new SQLException("您尚未开始事务");
		con.commit();
		con.close();
		//只用close，con仍为非空；必须将con设置为null，表示事务已经结束
		con=null;
	}

	public static void rollbackTransaction() throws SQLException {
		if(con==null) throw new SQLException("您尚未开始事务");
		con.rollback();
		con.close();
		con=null;
	}
	public static Connection getConnection() throws SQLException {
		//当con不为bull，说明已被调用，不再创建新的连接
		if(con!=null) {
			return con;
		}
		return dataSource.getConnection();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}

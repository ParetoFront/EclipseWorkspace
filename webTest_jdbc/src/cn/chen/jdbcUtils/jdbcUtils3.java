package cn.chen.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.catalina.startup.TldConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//jdbcUtils3旨在实现事务的控制
public class jdbcUtils3 {
	// 创建连接池，需要c3p0配置文件的支持
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//事务专用连接
	private static ThreadLocal<Connection> tl=new ThreadLocal<>();
	//开启一个事务，为con赋值，并且能让commit和rollback操作获取到
	public static void beginTransaction() throws SQLException {
		Connection con=tl.get();
		//防止有人连续调用begin
		if(con!=null) throw new SQLException("您已经开始了一个事务");
		con=getConnection();
		con.setAutoCommit(false);
		tl.set(con);
	}

	// 提交事务，需要获取begin提供的connection，然后调用commit
	public static void committransaction() throws SQLException {
		Connection con=tl.get();
		if(con==null) throw new SQLException("您尚未开始事务");
		con.commit();
		con.close();
//		//只用close，con仍为非空；必须将con设置为null，表示事务已经结束
//		con=null;
		tl.remove();
	}

	public static void rollbackTransaction() throws SQLException {
		Connection con=tl.get();
		if(con==null) throw new SQLException("您尚未开始事务");
		con.rollback();
		con.close();
		con=null;
		tl.remove();
	}
	//释放连接，判断连接是不是事务专用，如果是就不关闭，不是事务专用就关闭；
	public static void releaseConnection(Connection connection) throws SQLException {
		Connection con=tl.get();
		//如果con为null，则connection必定不是事务专用,则可以关闭
		if(con==null) connection.close();
		//如果con不为null，说明有事务，则进一步判断connection是否是否与con相等，若不等，说明connection不是事务专用，仍然关闭
		if(con!=connection) connection.close();
	}
	public static Connection getConnection() throws SQLException {
		//当con不为bull，说明已被调用，不再创建新的连接
		Connection con=tl.get();
		if(con!=null) {
			return con;
		}
		return dataSource.getConnection();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}

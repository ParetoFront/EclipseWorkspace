package cn.chen.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * @author cky
 * 这个类相比于QueryRunner的改进就是可以自行处理连接的问题，通过jdbcUtils3来与事务配合
 * 处理原理：
 */
public class TxQueryRunner extends QueryRunner{

	@Override
	public int[] batch(String sql, Object[][] params) throws SQLException {
		//1.得到连接
		//2.执行父类方法
		//3。释放链接
		//4.返回值
		Connection con=jdbcUtils3.getConnection();
		int[] result=super.batch(con, sql,params);
		jdbcUtils3.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=jdbcUtils3.getConnection();
		T result=super.query(con, sql,param,rsh);
		jdbcUtils3.releaseConnection(con);
		return result;
	}

	@Override
	public <T> T query(String sql, Object[] params, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=jdbcUtils3.getConnection();
		T result=super.query(con, sql,params,rsh);
		jdbcUtils3.releaseConnection(con);
		return result;
	}


	@Override
	public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
		Connection con=jdbcUtils3.getConnection();
		T result=super.query(con, sql,rsh);
		jdbcUtils3.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object... params) throws SQLException {
		Connection con=jdbcUtils3.getConnection();
		int result=super.update(con, sql,params);
		jdbcUtils3.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql, Object param) throws SQLException {
		Connection con=jdbcUtils3.getConnection();
		int result=super.update(con, sql,param);
		jdbcUtils3.releaseConnection(con);
		return result;
	}

	@Override
	public int update(String sql) throws SQLException {
		
		Connection con=jdbcUtils3.getConnection();
		int result=super.update(con, sql);
		jdbcUtils3.releaseConnection(con);
		return result;
	}
	
}

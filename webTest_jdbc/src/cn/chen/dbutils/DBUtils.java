package cn.chen.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

//简化jdbc的代码
public class DBUtils<T> {
	private DataSource dataSource;

	// 两个构造器
	public DBUtils() {
		super();
	}

	public DBUtils(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int update(String sql, Object[] params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			// 给pstmt赋值
			initParam(pstmt, params);
			// 执行pstmt并返回
			return pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public T query(String sql, RsHandler rh, Object[] params) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			initParam(pstmt, params);
			rs = pstmt.executeQuery();
			return (T) rh.handle(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {

		}
	}

	// 给sql中的参数赋值的方法
	private void initParam(PreparedStatement pstmt, Object[] params) throws Exception {
		for (int i = 0; i < params.length; i++) {
			pstmt.setObject(i + 1, params[i]);
		}
	}

	// 接口功能：处理rs，实现rs到javabean的映射
	interface RsHandler<T> {
		public T handle(ResultSet rs) throws SQLException;
	}
}

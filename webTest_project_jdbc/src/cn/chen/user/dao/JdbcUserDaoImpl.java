package cn.chen.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.chen.user.domain.User;

/**
 * @author cky
 *
 */
public class JdbcUserDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) {
		// 规范化代码，使用try-catch-finally
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();   // 得到连接
			String sql = "SELECT * FROM users WHERE username=?";// 准备sql模板
			pstmt = con.prepareStatement(sql); //获得pstmt
			pstmt.setString(1, username);  // 为sql模板赋值
			rs = pstmt.executeQuery();
			// rs转user
			if (rs == null) {
				return null;
			}
			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {}
		}

	}

	@Override
	public void add(User form) {
		// 规范化代码，使用try-catch-finally
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 得到连接
			con = JdbcUtils.getConnection();
			// 准备sql模板，获得pstmt
			String sql = "INSERT INTO users VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// 为sql模板赋值
			pstmt.setString(1, form.getUsername());
			pstmt.setString(2, form.getPassword());
			pstmt.setString(3, null);
			pstmt.setString(4, null);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}

}

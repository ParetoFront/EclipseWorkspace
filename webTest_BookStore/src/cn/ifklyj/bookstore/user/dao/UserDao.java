package cn.ifklyj.bookstore.user.dao;
//user持久层

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import cn.ifklyj.bookstore.user.domain.User;
import cn.itcast.jdbc.TxQueryRunner;

public class UserDao {
	private QueryRunner qr = new TxQueryRunner();

	public User findByUsername(String username) {
		try {
			String sql = "select * from users where username=?";
			return qr.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findByEmail(String email) {
		try {
			String sql = "select * from users where email=?";
			return qr.query(sql, new BeanHandler<User>(User.class), email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User findByCode(String code) {

		try {
			String sql = "select * from users where code=?";
			return qr.query(sql, new BeanHandler<User>(User.class), code);
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public void updateState(String uid, boolean state) {

		try {
			String sql = "update users set state=? where uid=?";
			Object[] params = { state, uid };
			qr.update(sql, params);
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public void add(User user) {
		try {
			String sql = "insert into users values(?,?,?,?,?,?)";
			Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(),
					user.isState() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

package cn.chen.cstm.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.chen.cstm.domain.Customer;
import cn.itcast.jdbc.TxQueryRunner;

public class CustomerDao {
	private QueryRunner qr = new TxQueryRunner();

	public void add(Customer c) {
		String sql = "insert into customers values(?,?,?,?,?,?,?)";
		Object[] params = { c.getCid(), c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(),
				c.getDescription() };
		try {

			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

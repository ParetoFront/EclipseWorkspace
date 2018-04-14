package cn.chen.cstm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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

	public List<Customer> findAll() {
		try {
			String sql = "select * from customers";
			return qr.query(sql, new BeanListHandler<Customer>(Customer.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Customer load(String cid) {
		String sql = "select * from customers where cid=?";
		Object[] params = { cid };
		try {
			return qr.query(sql, new BeanHandler<Customer>(Customer.class), params);
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public void edit(Customer c) {
		String sql = "update customers set cname=?,gender=?,birthday=?,cellphone=?,email=?,description=? where cid=?";
		Object[] params = { c.getCname(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(),
				c.getDescription(), c.getCid() };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void delete(String cid) {
		String sql = "delete from customers where cid=?";
		Object[] params = { cid };
		try {
			qr.update(sql, params);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 多条件组合查询
	public List<Customer> query(Customer criteria) {
		try {
			// 写sql前半部分
			StringBuilder sql = new StringBuilder("select * from customers where 1=1");

			List<Object> params = new ArrayList<Object>();

			String cname = criteria.getCname();
			if (cname != null && !cname.trim().isEmpty()) {
				//注意要有空格
				sql.append(" and cname like ?");
				//支持模糊查询
				params.add("%"+cname+"%");
			}
			String gender = criteria.getGender();
			if (gender != null && !gender.trim().isEmpty()) {
				sql.append(" and gender=?");
				params.add(gender);
			}
			String cellphone = criteria.getCellphone();
			if (cellphone != null && !cellphone.trim().isEmpty()) {
				sql.append(" and cellphone like ?");
				params.add("%"+cellphone+"%");
			}
			String email = criteria.getEmail();
			if (email != null && !email.trim().isEmpty()) {
				sql.append(" and email like ?");
				params.add("%"+email+"%");
			}

			return qr.query(sql.toString(), new BeanListHandler<>(Customer.class), params.toArray());
		} catch (SQLException e) {

			throw new RuntimeException();
		}

	}
}

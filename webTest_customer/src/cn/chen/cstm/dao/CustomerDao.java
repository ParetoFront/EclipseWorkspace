package cn.chen.cstm.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.chen.cstm.domain.Customer;
import cn.chen.cstm.domain.PageBean;
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

	public PageBean<Customer> findAll(int pc, int ps) {
		try {
			PageBean<Customer> pb = new PageBean<>();
			pb.setPc(pc);
			pb.setPs(ps);
			String sql = "select count(*) from customers";
			// 得到tr
			Number num = (Number) qr.query(sql, new ScalarHandler<>());
			int tr = num.intValue();
			pb.setTr(tr);
			// 得到beanList
			sql = "select * from customers order by cname limit ?,?";
			Object[] params = { (pc - 1) * ps, ps };
			List<Customer> beanList = qr.query(sql, new BeanListHandler<Customer>(Customer.class), params);
			pb.setBeanList(beanList);
			return pb;

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

	public PageBean<Customer> query(Customer criteria, int ps, int pc) {

		PageBean<Customer> pb = new PageBean<>();
		pb.setPc(pc);
		pb.setPs(ps);
		// 得到tr
		try {
			StringBuilder count_sql = new StringBuilder("select count(*) from customers");
			StringBuilder where_sql = new StringBuilder(" where 1=1");
			List<Object> params = new ArrayList<Object>();
			String cname = criteria.getCname();
			if (cname != null && !cname.trim().isEmpty()) {
				// 注意要有空格
				where_sql.append(" and cname like ?");
				// 支持模糊查询
				params.add("%" + cname + "%");
			}
			String gender = criteria.getGender();
			if (gender != null && !gender.trim().isEmpty()) {
				where_sql.append(" and gender=?");
				params.add(gender);
			}
			String cellphone = criteria.getCellphone();
			if (cellphone != null && !cellphone.trim().isEmpty()) {
				where_sql.append(" and cellphone like ?");
				params.add("%" + cellphone + "%");
			}
			String email = criteria.getEmail();
			if (email != null && !email.trim().isEmpty()) {
				where_sql.append(" and email like ?");
				params.add("%" + email + "%");
			}
			String sql = count_sql.append(where_sql).toString();
			Number num = (Number) qr.query(sql, new ScalarHandler<>(), params.toArray());
			pb.setTr(num.intValue());
			// 获取beanList
			StringBuilder bean_sql = new StringBuilder("select * from customers");
			StringBuilder limit_sql = new StringBuilder(" limit ?,?");
			sql = bean_sql.append(where_sql).append(limit_sql).toString();
			params.add((pc - 1) * ps); // 添加额外两个参数
			params.add(ps);
			List<Customer> beanList = qr.query(sql, new BeanListHandler<Customer>(Customer.class), params.toArray());
			pb.setBeanList(beanList);

			return pb;
		} catch (SQLException e) {

			throw new RuntimeException("beansql 出错");
		}
	}
}

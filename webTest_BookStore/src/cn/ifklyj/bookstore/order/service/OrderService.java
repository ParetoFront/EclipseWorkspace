package cn.ifklyj.bookstore.order.service;

import java.sql.SQLException;

import cn.ifklyj.bookstore.order.dao.OrderDao;
import cn.ifklyj.bookstore.order.domain.Order;
import cn.itcast.jdbc.JdbcUtils;

public class OrderService {
	private OrderDao orderDao = new OrderDao();

	/*
	 * 添加订单，其中添加订单条目时需要使用事务，故service需要处理事务
	 */
	public void add(Order order) {
		try {
			JdbcUtils.beginTransaction();// 开始事务
			orderDao.addOrder(order); // 插入订单
			orderDao.addOrderItemList(order.getOrderItemList()); // 插入订单中的条目
			JdbcUtils.commitTransaction();

		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();  //有异常则回滚
			} catch (SQLException e1) {
				
			}
			throw new RuntimeException(e);
		}
	}
}

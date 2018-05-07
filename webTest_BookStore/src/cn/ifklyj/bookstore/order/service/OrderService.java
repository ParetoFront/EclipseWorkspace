package cn.ifklyj.bookstore.order.service;

import java.sql.SQLException;
import java.util.List;

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

	public List<Order> myOrders(String uid) {
		
		return orderDao.findByUid(uid);
	}

	public Order load(String oid) {
		return orderDao.load(oid);
	}
	/*
	 * 用户点击确认收货后，在此检验订单状态是否为3（待收货状态）,若是，则修改状态为4
	 */
	public void confirm(String oid)  throws OrderException{
		int state=orderDao.getStateByOid(oid);
		if(state!=3) {
			throw new OrderException("订单确认失败");
		}
		orderDao.updatestate(oid, 4);
	}
}

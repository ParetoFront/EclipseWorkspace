package cn.ifklyj.bookstore.order.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import cn.ifklyj.bookstore.order.domain.Order;
import cn.ifklyj.bookstore.order.domain.OrderItem;
import cn.itcast.jdbc.TxQueryRunner;

public class OrderDao {
	private QueryRunner qr=new TxQueryRunner();
	public void addOrder(Order order) {
		try {
			String sql="insert into orders values(?,?,?,?,?,?)";
			//将util的Date转化为sql的Date
//			Timestamp timestamp=new Timestamp(order.getOrdertime().getTime());
			java.sql.Date sqlDate=new java.sql.Date(order.getOrdertime().getTime());
			Object[] params= {order.getOid(),sqlDate,order.getTotal(),
					order.getState(),order.getOwner().getUid(),order.getAddress()};
			qr.update(sql,params);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void addOrderItemList(List<OrderItem> orderItemList) {
		/*
		 * QueryRunner的batch方法中，params是一个二维数组，每个子数组用于执行一次query
		 */
		try {
			String sql="insert into orderitem values(?,?,?,?,?)";
			//将orderItemList转化为二维数组,每个orderItem的数据对应一个一维数组
			Object[][] params=new Object[orderItemList.size()][];
			for(int i=0;i<orderItemList.size();i++) {
				OrderItem item=orderItemList.get(i);
				params[i]=new Object[] {item.getIid(),item.getCount(),item.getSubtotal(),
						item.getOrder().getOid(),item.getBook().getBid()};
			}
			qr.batch(sql, params);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

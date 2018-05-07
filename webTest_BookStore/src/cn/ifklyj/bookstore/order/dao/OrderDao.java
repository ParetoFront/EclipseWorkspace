package cn.ifklyj.bookstore.order.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.ifklyj.bookstore.book.domain.Book;
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
			//将orderItemList转化为二维数组,每个orderItem的数据对应一个一维数组，在批处理中一个一维数组对应一次查询
			Object[][] params=new Object[orderItemList.size()][];
			for(int i=0;i<orderItemList.size();i++) {
				OrderItem item=orderItemList.get(i);
				params[i]=new Object[] {item.getIid(),item.getCount(),item.getSubtotal(),
						item.getOrder().getOid(),item.getBook().getBid()};
			}
			qr.batch(sql, params);  //批处理
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Order> findByUid(String uid) {
		//根据uid获取orderList
		//遍历orderList，再遍历每个order的orderItemList
		try {
			String sql="select * from orders where uid=?";
			List<Order> orderList=qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
			for(Order order:orderList) {
				loadOrderItems(order);  //为每个order加载其item
			}
			return orderList;
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	/*
	 * 本方法为orde加载其OrderItem
	 */
	private void loadOrderItems(Order order) {
		try {
			//由于数据库中orderItem表只有bid、uid、oid的痘印关系，若要将book信息添加到OrderItem中，需要多表查询，即OrderItem和book两表
			String sql="select * from orderitem i,books b where i.bid=b.bid and oid=?";
			//结果集中一行记录对应的不是一个bean，所以不再使用BeanListHandler，而是使用MapListHandler
			//mapList中每一个map对应一个OrderItem
			List<Map<String,Object>> mapList=qr.query(sql, new MapListHandler(),order.getOid());
			//接下来将mapList转化为OrderItemList
			List<OrderItem> orderItemList=toOrderItemList(mapList);
			order.setOrderItemList(orderItemList);
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	/*
	 * 将mapList转化为OrderItemList
	 */
	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItemList=new ArrayList<OrderItem>();
		for(Map<String,Object> map:mapList) {
			OrderItem item=toOrderItem(map);
			orderItemList.add(item);
		}
		return orderItemList;
	}
	/*
	 * 将单个map转化为OrderItem和Book两个对象
	 */
	private OrderItem toOrderItem(Map<String, Object> map) {
		try {
			OrderItem orderItem=new OrderItem();
			BeanUtils.populate(orderItem, map);
			Book book=new Book();
			BeanUtils.populate(book, map);
			orderItem.setBook(book);
			return orderItem;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public Order load(String oid) {
		try {
			String sql="select * from orders where oid=?";
			Order order=qr.query(sql, new BeanHandler<Order>(Order.class),oid);
			//注意，此处查询得到的order还没有orderItemList，需要手动加载
			loadOrderItems(order);
			return order;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int getStateByOid(String oid) {
		try {
			String sql="select state from orders where oid=?";
			Number num=(Number) qr.query(sql, new ScalarHandler(),oid);  //用Number接收一个字符串，用intValue方法转为int
			return num.intValue();
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
	public void updatestate(String oid,int state) {
		try {
			String sql="update orders set state=? where oid=?";
			Object[] params= {state,oid};
			qr.update(sql,params);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

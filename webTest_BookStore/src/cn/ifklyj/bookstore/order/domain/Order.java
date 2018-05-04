package cn.ifklyj.bookstore.order.domain;

import java.util.Date;
import java.util.List;

import cn.ifklyj.bookstore.user.domain.User;

public class Order {
	private String oid;
	private Date ordertime;  //注意此处必须导入util的date，不能使用sql的date，以实现不依赖于数据库
	private double total;
	private int state;  //订单状态：1未付款 2已付款未发货 3已发货未确认收货 4已确认收货
	private User owner;
	private String address;
	private List<OrderItem> orderItemList;
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

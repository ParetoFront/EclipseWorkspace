package cn.ifklyj.bookstore.cart.domain;


import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap<>(); //使用LinkedHashMap是为了保留添加条目的顺序
	
	public double getTotal() {
		//使用BigDecimal处理二进制的误差
		BigDecimal total=new BigDecimal("0");
		for(CartItem cartItem:map.values()) {
			BigDecimal subtotal=new BigDecimal(""+cartItem.getSubTotal());
			total=total.add(subtotal);
		}
		return total.doubleValue();
	}
	public void add(CartItem cartItem) {
		String bid=cartItem.getBook().getBid();
		if(map.containsKey(bid)) {   //购物车已有该书
			CartItem newItem=map.get(bid);
			newItem.setCount(newItem.getCount()+cartItem.getCount());
			map.put(bid, newItem);
		}else {
			map.put(cartItem.getBook().getBid(), cartItem);
		}
		
	}
	public void clear() {
		map.clear();
	}
	public void delete(String bid) {
		map.remove(bid);
	}
	//获取所有条目
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
}

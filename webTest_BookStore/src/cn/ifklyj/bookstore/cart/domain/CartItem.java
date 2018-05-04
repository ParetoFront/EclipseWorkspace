package cn.ifklyj.bookstore.cart.domain;

import java.math.BigDecimal;

import cn.ifklyj.bookstore.book.domain.Book;

public class CartItem {
	private Book book;
	private int count;
	//获取小计的方法，蛋挞没有具体的成员
	public double getSubTotal() {
		//需要用BigDecimal处理二进制误差问题
		BigDecimal d1=new BigDecimal(book.getPrice()+"");  //加一个空字符串使price由double转为String
		BigDecimal d2=new BigDecimal(count+"");
		return d1.multiply(d2).doubleValue();
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}

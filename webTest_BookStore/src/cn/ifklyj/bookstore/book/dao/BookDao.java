package cn.ifklyj.bookstore.book.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ifklyj.bookstore.book.domain.Book;
import cn.itcast.jdbc.TxQueryRunner;

public class BookDao {
	private QueryRunner qr=new TxQueryRunner();
	public List<Book> findAll(){
		try {
			String sql="select * from books";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
	public List<Book> findByCategory(String cid) {
		try {
			String sql="select * from books where cid=?";
			return qr.query(sql, new BeanListHandler<Book>(Book.class),cid);
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
	public Book findByBid(String bid) {
		try {
			String sql="select * from books where bid=?";
			return qr.query(sql, new BeanHandler<Book>(Book.class),bid);
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}

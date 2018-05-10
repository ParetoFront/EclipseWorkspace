package cn.ifklyj.bookstore.book.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.ifklyj.bookstore.book.domain.Book;
import cn.ifklyj.bookstore.category.domain.Category;
import cn.itcast.jdbc.TxQueryRunner;

public class BookDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Book> findAll() {
		try {
			String sql = "select * from books where del=0";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public List<Book> findByCategory(String cid) {
		try {
			String sql = "select * from books where cid=? and del=0";
			return qr.query(sql, new BeanListHandler<Book>(Book.class), cid);
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public Book findByBid(String bid) {
		try {

			String sql = "select * from books where bid=? and del=0";
			// 在admin/book/desc.jsp页面需要显示book的所属类别，考虑到books表查询后得到的book分类信息只有cid
			// 因此需要使用MapHandler处理结果集，将查询结果转化为book和category两个对象，并将category添加到book中
			Map<String, Object> map = qr.query(sql, new MapHandler(), bid);
			Category category = new Category();
			BeanUtils.populate(category, map);
			Book book = new Book();
			BeanUtils.populate(book, map);
			book.setCategory(category);
			return book;
		} catch (SQLException | IllegalAccessException | InvocationTargetException e) {

			throw new RuntimeException(e);
		}
	}

	public int getcountByCid(String cid) {
		try {
			String sql = "select count(*) from books where cid=? and del=0";
			Number count = (Number) qr.query(sql, new ScalarHandler(), cid);
			return count.intValue();
		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	public void add(Book book) {
		try {
			String sql="insert into books values(?,?,?,?,?,?,?)";
			Object[] params= {book.getBid(),book.getBname(),book.getPrice(),
					book.getAuthor(),book.getImage(),book.getCategory().getCid(),0};
			qr.update(sql,params);
		} catch (SQLException e) {	
			throw new RuntimeException(e);
		}	
	}
	public void delete(String bid) {
		try {
			String sql="update books set del=1 where bid=?";
			qr.update(sql,bid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void mod(Book book) {
		try {
			String sql="update books set bname=?,price=?,author=?,image=?,cid=? where bid=?";
			Object[] params= {book.getBname(),book.getPrice(),book.getAuthor(),
					book.getImage(),book.getCategory().getCid(),book.getBid()};
			qr.update(sql,params);
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}

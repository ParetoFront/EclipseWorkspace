package cn.ifklyj.bookstore.book.service;

import java.util.List;

import cn.ifklyj.bookstore.book.dao.BookDao;
import cn.ifklyj.bookstore.book.domain.Book;

public class BookService {
	private BookDao bookDao = new BookDao();
	
	public List<Book> findAll() {
		return bookDao.findAll();
	}
	//按分类查询图书
	public List<Book> findByCategory(String cid) {
		return bookDao.findByCategory(cid);
	}

	// 查询单本图书的详细页
	public Book load(String bid) {
		return bookDao.findByBid(bid);
	}
	public void add(Book book) {
		bookDao.add(book);
	}
	public void delete(String bid) {
		bookDao.delete(bid);
	}
	public void mod(Book book) {
		bookDao.mod(book);
	}
}

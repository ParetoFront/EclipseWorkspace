package cn.chen.book.service;

import java.util.List;

import cn.chen.book.dao.BookDao;
import cn.chen.book.domain.Book;

public class BookService {
	BookDao bookDao=new BookDao();
	public List<Book> findAll(){
		return bookDao.findAll();
	}
	public List<Book> findByCategory(int category){
		return bookDao.findByCategory(category);
	}
}

package cn.ifklyj.bookstore.category.service;

import java.util.List;

import cn.ifklyj.bookstore.book.dao.BookDao;
import cn.ifklyj.bookstore.category.dao.CategoryDao;
import cn.ifklyj.bookstore.category.domain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();
	private BookDao bookDao=new BookDao();
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void add(Category category) {
		categoryDao.add(category);
	}

	public void delete(String cid) {
		try {
			int count=bookDao.getcountByCid(cid);
			if(count>0) throw new CategoryException("该分类下有图书，不能删除");
			categoryDao.delete(cid);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public Category findByCid(String cid) {
		return categoryDao.findByCid(cid);
	}

	public void mod(Category category) {
		categoryDao.mod(category);
	}
}

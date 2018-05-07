package cn.ifklyj.bookstore.category.service;

import java.util.List;

import cn.ifklyj.bookstore.category.dao.CategoryDao;
import cn.ifklyj.bookstore.category.domain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void add(Category category) {
		categoryDao.add(category);
	}
}

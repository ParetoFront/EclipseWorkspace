package cn.ifklyj.bookstore.book.web.servlet;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.ifklyj.bookstore.book.domain.Book;
import cn.ifklyj.bookstore.book.service.BookService;
import cn.ifklyj.bookstore.category.domain.Category;
import cn.ifklyj.bookstore.category.service.CategoryService;
import cn.itcast.commons.CommonUtils;

@WebServlet("/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 之所以上传图书需要一个独立的servlet，是因为上传文件时会设置enctype，导致不能使用getParameter方法，
	 * 不能使用BaseServlet，需要使用doPost方法
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BookService bookService = new BookService();
		CategoryService categoryService = new CategoryService();
		try {
			// 上传文件三步
			// 创建工厂
			DiskFileItemFactory factory = new DiskFileItemFactory(15 * 1024, new File("f:/f/temp"));
			// 得到解析器
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// 设置单个文件大小限制
			sfu.setFileSizeMax(15 * 1024);
			List<FileItem> fileItemList = sfu.parseRequest(request);
			Map<String, String> map = new HashMap<String, String>();
			for (FileItem fileItem : fileItemList) {
				if (fileItem.isFormField()) { // 判断是否为普通表单项,若是则添加到map中
					map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
				}
			}
			Book book = new Book();
			BeanUtils.populate(book, map);
			book.setBid(CommonUtils.uuid());
			// 保存上传的图片
			String savepath = this.getServletContext().getRealPath("book_img");// 保存图片的文件夹的绝对路径
			String filename = CommonUtils.uuid() + "_" + fileItemList.get(1).getName(); // 文件名称
			// 校验文件格式
			if (!filename.toLowerCase().endsWith("jpg")) {
				request.setAttribute("msg", "您上传的文件不是jpg格式");
				//因为是重定向，所以图书编辑页面的分类下拉选单中category数据会丢失，需要重新保存
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
			}
			File destFile = new File(savepath, filename);
			fileItemList.get(1).write(destFile); // 以绝对路径保存
			book.setImage("book_img/" + filename); // 以相对路径保存图片路径
			// 校验图片尺寸,需要用到ImageIcon方法
			Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();
			if (image.getWidth(null) > 200 || image.getHeight(null) > 200) {
				request.setAttribute("msg", "您的图片尺寸超出200x200！");
				destFile.delete(); // 删除违规文件
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add/jsp").forward(request, response);
				return; // 加return，结束上传
			}
			// 组装category，保存到book
			Category category = new Category();
			BeanUtils.populate(category, map);
			book.setCategory(category);
			// 添加图书到数据库
			bookService.add(book);
			// 重定向到AdminBookServlet的findAll方法
			request.getRequestDispatcher("/AdminBookServlet?method=findAll").forward(request, response);

		} catch (Exception e) {
			// 按异常种类抛出异常
			if (e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "您上传的文件超过了15KB");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp").forward(request, response);
			}
		}

	}

}
package cn.chen.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> list = sfu.parseRequest(request);
			for(FileItem item:list) {
				if(item.isFormField()) {
					System.out.println("普通表单项为  "+item.getFieldName()+": "+item.getString("utf-8"));
				}else if(!item.isFormField()) {
					System.out.println("文件表单项为  ");
					System.out.println("contenttype="+item.getContentType());
					System.out.println("size="+item.getSize());
					System.out.println("name="+item.getFieldName());
					File file=new File("D:/upload.jpg");
					item.write(file);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}

}
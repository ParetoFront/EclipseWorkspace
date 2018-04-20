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
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.itcast.commons.CommonUtils;

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
		// 得到工厂,设置缓存大小和临时文件的目录
		DiskFileItemFactory factory = new DiskFileItemFactory(20*1024,new File("D:/temp"));
		// 生成解析器
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 限制单个文件大小为300kb
		sfu.setFileSizeMax(300 * 1024);
		// 限制整个表单的大小为1MB
		sfu.setSizeMax(1000 * 1024);
		try {
			// 解析request得到List
			List<FileItem> list = sfu.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) { // 判断为普通表单项
					System.out.println("普通表单项为  " + item.getFieldName() + ": " + item.getString("utf-8"));
				} else if (!item.isFormField()) {
					// 将文件表单项根据哈希值决定存储目录
					String root = request.getServletContext().getRealPath("/WEB-INF/files/");
					String filename = item.getName();
					int index = filename.lastIndexOf("\\");
					if (index != -1) {
						filename = filename.substring(index + 1);
					}
					int hashCode = filename.hashCode();
					String hex = Integer.toHexString(hashCode);
					File dir = new File(root + "\\" + hex.charAt(0) + "\\" + hex.charAt(1)); // 创建文件夹地址
					dir.mkdirs(); // 创建保存目标文件的文件夹
					// 现在为文件名加上uuid前缀，防止重名文件
					filename = CommonUtils.uuid() + "_" + filename;
					File file = new File(dir + "\\" + filename);
					item.write(file);
				}
			}
		} catch (FileUploadException e) {
			if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
				request.setAttribute("msg", "您上传的文件中有文件超出了单个文件大小的限制");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else if(e instanceof FileUploadBase.SizeLimitExceededException) {
				request.setAttribute("msg", "您上传的文件总大小超出了限制");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
package cn.chen.web.servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filePath="D:\\DNA.mp3";
		String filename="中文名称.mp3";
		String encode_filename=new String(filename.getBytes("GBK"),"ISO-8859-1");
		String contentType=this.getServletContext().getMimeType(filePath);
		String contentDisposition="attachment;filename="+encode_filename;
		FileInputStream input=new FileInputStream(filePath);
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		ServletOutputStream output=response.getOutputStream();
		BufferedInputStream bis=new BufferedInputStream(input);
		int size=0;
		byte[] bys=new byte[1024];
		while((size=bis.read(bys))!=-1) {
			output.write(bys,0,size);
		}
		output.flush();
		bis.close();
//		IOUtils.copy(input, output);
		input.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}

}
package cn.chen.book.filter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class StaticResponse extends HttpServletResponseWrapper {
	private HttpServletResponse response;
	private PrintWriter pw;
	//需要额外传入一个path参数，用于指定流对象
	public StaticResponse(HttpServletResponse response,String path) throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		this.response=response;
		//创建一个与html文件绑定在一起的流对象
		pw=new PrintWriter(path,"utf-8");
	}
	public PrintWriter getWriter() {
		//返回一个与html绑定的对象
		return pw;
	}
}

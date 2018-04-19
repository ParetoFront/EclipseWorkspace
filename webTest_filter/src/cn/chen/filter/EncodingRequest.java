package cn.chen.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	@Override
	public String getParameter(String arg0) {
		String value=request.getParameter(arg0);
		//在getParameter内部进行转码
		try {
			value=new String(value.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			
			throw new RuntimeException(e);
		}
		return value;
	}
}

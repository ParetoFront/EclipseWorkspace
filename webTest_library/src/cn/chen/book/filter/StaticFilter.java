package cn.chen.book.filter;

import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Choose;

/**
 * Servlet Filter implementation class StaticFilter
 */
@WebFilter("/BookServlet")
public class StaticFilter implements Filter {
	private FilterConfig fConfig;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		/*
		 * 1.第一次访问时查找对应的html页面是否存在，若存在则重定向至html，不再执行servlet
		 * 2.如果不存在，放行，访问servlet，servlet执行后会用show.jsp输出，现在将show.jsp输出到html，再重定向至该html
		 * category有四种可能：
		 *  null-->null.html
		 *  1-->1.html
		 *  2-->2.html
		 *  3-->3.html
		 *  保存在htmls文件夹下
		 */
		String category = request.getParameter("category");
		String htmlPage=category+".html"; //文件名
		String htmlPath=fConfig.getServletContext().getRealPath("/htmls"); //文件路径
		File file=new File(htmlPath,htmlPage);
		//若html已存在，则直接重定向
		if(file.exists()) {
			resp.sendRedirect(req.getContextPath()+"/htmls/"+htmlPage);
			return;
		}
		//文件不存在，则生成文件
		StaticResponse sr=new StaticResponse(resp, file.getAbsolutePath());
		//调包response，本来输出到show.jsp的内容输出到html中
		chain.doFilter(request,sr);
		//此时html页面已经存在，重定向至该页面
		resp.sendRedirect(req.getContextPath()+"/htmls/"+htmlPage);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.fConfig=arg0;
	}

}

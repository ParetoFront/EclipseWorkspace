package cn.chen.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/user/*")
public class UserFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//判断session域中是否存在admin，如果存在，放行
		//判断session域中是否存在username，如果存在就放行，不存在则打回到login.jsp
		HttpServletRequest req=(HttpServletRequest) request;
		String name=(String) req.getSession().getAttribute("admin");
		if(name!=null) {
			chain.doFilter(request, response);
			return;
		}
		name=(String) req.getSession().getAttribute("user");
		if(name!=null) {
			chain.doFilter(request, response);
			return;
		}else {
			req.setAttribute("msg", "您不是会员或管理员，请登录");
			req.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

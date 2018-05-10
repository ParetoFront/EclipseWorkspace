package cn.ifklyj.bookstore.user.web.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import cn.ifklyj.bookstore.user.domain.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		servletNames = { 
				"OrderServlet", 
				"CartServlet"
		},
		urlPatterns = { 
				"/jsps/cart/*", 
				"/jsps/order/*"
		}
		)
public class LoginFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器正在运行");
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		User user=(User) httpRequest.getSession().getAttribute("session_user");
		System.out.println(user);
		if(user!=null) {
			chain.doFilter(request, response);
			return;
		}else {
			request.setAttribute("msg", "您尚未登录！");
			request.getRequestDispatcher("/jsps/user/login.jsp").forward(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器已创建");
	}

}

package cn.chen.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author cky 从application中获取map 从request中获取当前ip 进行统计工作
 */
@WebFilter("/*")
public class IP_count_Filter implements Filter {
	private static FilterConfig fConfig;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletContext application = fConfig.getServletContext();
		Map<String, Integer> map = (Map<String, Integer>) application.getAttribute("map");
		String ip = request.getRemoteAddr();
		if (map.containsKey(ip)) {
			int cnt = map.get(ip);
			map.put(ip, cnt + 1);
		} else {
			map.put(ip, 1);
		}
		application.setAttribute("map", map);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

	public void destroy() {

	}
}

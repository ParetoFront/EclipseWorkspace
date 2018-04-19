package cn.chen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Test;

public class Afilter implements Filter {
	//	Filter时单例的
	@Override
	public void destroy() {
		//销毁时执行
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//过滤器执行时执行
		System.out.println("我生效了");
		arg2.doFilter(arg0, arg1);
	}
	@Test
	public void fun() {
		System.out.println(Integer.MAX_VALUE);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//过滤器创建后马上执行
		System.out.println("filter出生了");
	}

}

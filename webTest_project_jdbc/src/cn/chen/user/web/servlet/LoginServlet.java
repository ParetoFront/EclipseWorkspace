package cn.chen.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.chen.user.domain.User;
import cn.chen.user.service.UserException;
import cn.chen.user.service.UserService;
import cn.itcast.commons.CommonUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//封装表单数据到user中
		User form=CommonUtils.toBean(request.getParameterMap(), User.class);
		//校验
		Map<String, String> login_errors = new HashMap<>();
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			login_errors.put("username", "用户名不能为空");
		} else if (username.length() < 3 || username.length() > 20) {
			login_errors.put("username", "用户名长度应在3-20之间");
		}

		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			login_errors.put("password", "密码不能为空");
		} else if (password.length() < 3 || password.length() > 20) {
			login_errors.put("password", "密码长度应在3-20之间");
		}
		// 校验验证码
		String verifycode = form.getVerifycode();
		String sessionVerifycode = (String) request.getSession().getAttribute("session_vcode");
		if (!verifycode.equalsIgnoreCase(sessionVerifycode)) {
			login_errors.put("verifycode", "验证码错误！");
		}
		if (login_errors != null && login_errors.size() > 0) {
			request.setAttribute("login_errors", login_errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			return;   //注意加return，表示不再执行下面的动作
		}
		//开始查询用户名是否在数据库中
		UserService userService = new UserService();
		try {
			User user=userService.login(form);
			request.getSession().setAttribute("sessionUser", user);
			//登录成功，重定向到index.jsp
			response.sendRedirect(request.getContextPath()+"/user/index.jsp");
		}catch(UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
	}

}
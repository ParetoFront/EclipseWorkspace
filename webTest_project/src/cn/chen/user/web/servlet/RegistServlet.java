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

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		// 将表单中的数据封装到user中
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);

		// 校验步骤放在得到表单数据后，放在查询用户前
		// 使用map类型来装载错误信息（因为错误信息可能有多条）
		// username、password应非空
		// username、password长度应在3-20
		// 验证码是否正确

		// 校验失败时，向map添加错误信息
		// 判断map是否非空，若非空则保存map到request域，保存form到request域（回显），转发回regist.jsp
		// 在regist.jsp页面中，显示map中的错误信息${map.username }
		Map<String, String> regist_errors = new HashMap<>();
		String username = form.getUsername();
		if (username == null || username.trim().isEmpty()) {
			regist_errors.put("username", "用户名不能为空");
		} else if (username.length() < 3 || username.length() > 20) {
			regist_errors.put("username", "用户名长度应在3-20之间");
		}

		String password = form.getPassword();
		if (password == null || password.trim().isEmpty()) {
			regist_errors.put("password", "密码不能为空");
		} else if (password.length() < 3 || password.length() > 20) {
			regist_errors.put("password", "密码长度应在3-20之间");
		}
		// 校验验证码
		String verifycode = form.getVerifycode();
		String sessionVerifycode = (String) request.getSession().getAttribute("session_vcode");
		if (!verifycode.equalsIgnoreCase(sessionVerifycode)) {
			regist_errors.put("verifycode", "验证码错误！");
		}
		if (regist_errors != null && regist_errors.size() > 0) {
			request.setAttribute("regist_errors", regist_errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			return;   //注意加return，表示不再执行下面的动作
		}
		//校验通过，开始尝试注册
		UserService userService = new UserService();
		try {
			userService.regist(form);
			response.getWriter().print(
					"<h1>注册成功！</h1>" + "<a href='" + request.getContextPath() + "/user/login.jsp" + "'>点击这里去登录</a>");
		} catch (UserException e) {
			// 注册失败则转发错误信息
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
		}
	}

}
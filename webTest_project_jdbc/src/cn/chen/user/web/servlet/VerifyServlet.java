package cn.chen.user.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.vcode.utils.VerifyCode;

//import cn.itcast.vcode.utils.VerifyCode;

@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//生成图片
//保存图片信息到session
//图片响应给客户端
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		VerifyCode vc=new VerifyCode();
		BufferedImage bi=vc.getImage();
		request.getSession().setAttribute("session_vcode", vc.getText());
		VerifyCode.output(bi, response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
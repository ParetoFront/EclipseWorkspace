package cn.ifklyj.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ifklyj.domain.Province;
import cn.ifklyj.service.Service;
import net.sf.json.JSONArray;

@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		Service service= new Service();
		List<Province> list=service.findAllProvince();
		String json=JSONArray.fromObject(list).toString();
		response.getWriter().print(json);
	}


}
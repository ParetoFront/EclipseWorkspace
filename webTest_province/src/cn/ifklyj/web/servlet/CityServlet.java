package cn.ifklyj.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ifklyj.domain.City;
import cn.ifklyj.service.Service;
import net.sf.json.JSONArray;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Service service=new Service();
		int pid=Integer.parseInt(request.getParameter("pid"));
		List<City> list=service.findByProvince(pid);
		String json=JSONArray.fromObject(list).toString();
		System.out.println(json);
		response.getWriter().print(json);
	}

}
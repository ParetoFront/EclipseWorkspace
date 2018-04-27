package cn.chen.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.*;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//注意，此处要改为xml
		response.setContentType("text/xml; charset=UTF-8");
		//获取省份名称，加载该省的的城市名称，返回字符串
		
		try {
			// 创建解析器对象
			SAXReader reader = new SAXReader();
			// 调用解析器的读方法，传递一个流对象，得到document
			InputStream input = this.getClass().getResourceAsStream("/china.xml");
			Document doc = reader.read(input);
			
			//获取参数
			String proName=request.getParameter("proName");
			//方括号中的为条件，即name=provinceName
			//注意，正因为这里是一个字符串的拼接。同时注意双引号
			Element proEle=(Element) doc.selectSingleNode("//province[@name='"+proName+"']");  
			String xmlStr=proEle.asXML();  //将元素转化为字符串
			response.getWriter().print(xmlStr);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

}
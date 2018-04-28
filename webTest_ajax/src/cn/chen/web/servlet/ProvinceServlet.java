package cn.chen.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 响应全国所有省名称，需要dom4j.jar解析xml文件
		// 返回的字符串中的省份用逗号隔开

		try {
			// 创建解析器对象
			SAXReader reader = new SAXReader();
			// 调用解析器的读方法，传递一个流对象，得到document
			InputStream input = this.getClass().getResourceAsStream("/china.xml");
			Document doc = reader.read(input);
			// 查询所有province的name属性，得到一个属性对象
			// 循环遍历，得到用逗号隔开的字符串
			List<Attribute> arrList = doc.selectNodes("//province/@name"); //注意双引号
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arrList.size(); i++) {
				sb.append(arrList.get(i).getValue());
				if (i < arrList.size() - 1) {
					sb.append(",");
				}
			}
			response.getWriter().print(sb);   //注意此处必须用print，若用println，则字符串最后会带一个/r/n
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	}

}
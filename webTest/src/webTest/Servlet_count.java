package webTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_count")
public class Servlet_count extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet_count() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app=this.getServletContext();
		Integer count=(Integer) app.getAttribute("count");
		if(count==null) {
			app.setAttribute("count", 1); 
		}else {
			app.setAttribute("count",++count );
		}
		//向浏览器输出，需要响应对象
		PrintWriter pw=response.getWriter();
		pw.println("<h1>"+count+"</h1>");
	}

	
}

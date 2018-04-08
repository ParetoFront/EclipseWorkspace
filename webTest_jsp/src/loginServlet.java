

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(!"itcast".equalsIgnoreCase(username)) {
			//附加项：将用户名保存到cookie，
			//用户再次打开login.jsp时会读取cookie中的信息填写到登录文本框中
			Cookie cookie=new Cookie("uname",username);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);   
			
			//登陆成功，向session保存用户信息，并重定向至succ1
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("/webTest_jsp/session_login/succ1.jsp");
		}else {
			//登录失败则保存错误信息到request中，通过转发返回login.jsp
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/session_login/login.jsp").forward(request, response);
		}
	}

}

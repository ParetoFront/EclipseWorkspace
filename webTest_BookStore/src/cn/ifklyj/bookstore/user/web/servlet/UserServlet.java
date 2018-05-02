package cn.ifklyj.bookstore.user.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ifklyj.bookstore.user.domain.User;
import cn.ifklyj.bookstore.user.service.UserException;
import cn.ifklyj.bookstore.user.service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import cn.itcast.servlet.BaseServlet;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserService();
	
	public String regist(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//封装表单数据到bean，这里命名为form
		//补全uid
		//输入校验，用户名和邮箱，保存错误信息到request，转发到regist.jsp
		//调用service方法完成注册
		//发邮件
		//保存成功信息到msg.jsp
		
		try {
			User form =new User();
			BeanUtils.populate(form,req.getParameterMap());
			form.setUid(CommonUtils.uuid());
			form.setCode(CommonUtils.uuid()+CommonUtils.uuid());  //32位校验码
			
			Map<String,String> errors=new HashMap<>();
			String username=form.getUsername();
			if(username==null||username.trim().isEmpty()) {
				errors.put("username", "用户名不能为空");
			}else if(username.length()>10 ||username.length()<3) {
				errors.put("username", "用户名长度应在3-10之间");
			}
			String password=form.getPassword();
			if(password==null||password.trim().isEmpty()) {
				errors.put("password", "密码不能为空");
			}else if(password.length()>10 ||password.length()<3) {
				errors.put("password", "密码长度应在3-10之间");
			}
			String email=form.getEmail();
			if(email==null||email.trim().isEmpty()) {
				errors.put("email", "email不能为空");
			}else if(!email.matches("\\w+@\\w+\\.\\w+")) {   //正则表达式
				errors.put("email", "email格式不正确");
			}
			if(errors.size()>0) {
				req.setAttribute("errors", errors);
				req.setAttribute("form", form);
				return "f:/jsps/user/regist.jsp";
			}
			//校验完成，调用service
			try {
				userService.regist(form);
				
			} catch (UserException e) {
				//保存异常信息，保存form，转发到regist.jsp
				req.setAttribute("msg", e.getMessage());
				req.setAttribute("form", form);
				return "f:/jsps/user/regist.jsp";
			}
			//发送激活邮件
			Properties props=new Properties();
			props.load(this.getClass().getClassLoader().
					getResourceAsStream("email_template.properties"));
			String host=props.getProperty("host");   //主机
			String uname=props.getProperty("uname"); //用户名
			String pwd=props.getProperty("pwd");     //密码
			String from=props.getProperty("from");  //发件人
			String to=form.getEmail();  //收件人
			String subject =props.getProperty("subject");  //主题
			String content=props.getProperty("content");   //内容
			content=MessageFormat.format(content, form.getClass());  //替换配置文件中的占位符{0}
			Session session=MailUtils.createSession(host, uname, pwd);
			Mail mail=new Mail(from,to,subject,content);
			try {
				MailUtils.send(session, mail);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			req.setAttribute("msg", "注册成功！请到邮箱查收激活邮件！");
			return "f:/jsps/msg.jsp";
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			throw new RuntimeException(e);
		}
	}
	public String active(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("您激活了");
		return null;
	}
}

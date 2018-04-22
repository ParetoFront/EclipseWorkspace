package cn.chen.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

import com.sun.mail.util.MimeUtil;

import cn.itcast.mail.AttachBean;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

public class JavaMailTest {
	@Test
	public void fun() throws Exception, MessagingException {
		// 创建session，session需要prop和auth作为参数
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("chen", "mima");
			}
		};
		Session session = Session.getInstance(prop, auth);
		// 创建MimeMessage
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("xxx@163.com")); // 设置发件人
		msg.setRecipients(RecipientType.TO, "xxx@qq.com"); // 收件人
		msg.setRecipients(RecipientType.CC, "xxx@163.com"); // 设置抄送（会有抄送信息）
		msg.setRecipients(RecipientType.BCC, "xxx@163.com"); // 暗送（只有发送者和接受者知道该暗送）

		msg.setSubject("这是一封测试邮件");
		msg.setContent("hello", "text/html;charset=utf-8");

		Transport.send(msg);
	}

	/*
	 * 发送含有附件的邮件 1.创建一个多部件的不见内容MimeMultipart
	 * 2.MimeMultipart中包含两个主体部件：一个是文本内容，一个是附件，这种部件叫MimeBodyPart
	 * 3.将MimeMultipart传给MimeMessage
	 */
	@Test
	public void fun2() throws Exception {
		// 创建session，session需要prop和auth作为参数
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("chen", "mima");
			}
		};
		Session session = Session.getInstance(prop, auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("chen@163.com")); // 设置发件人
		msg.setRecipients(RecipientType.TO, "xxx@qq.com"); // 收件人
		
		MimeMultipart list = new MimeMultipart();
		MimeBodyPart part1=new MimeBodyPart();
		part1.setContent("本邮件包含附件","text/html;charset=utf-8");
		list.addBodyPart(part1);
		
		MimeBodyPart part2=new MimeBodyPart();
		part2.attachFile(new File("D://test.jpg"));
		part2.setFileName(MimeUtility.encodeText("测试图片.jpg"));  //设置文件名称，其中encodeText用于解决中文乱码
		list.addBodyPart(part2);
		
		msg.setContent(list);
		Transport.send(msg);
	}
	@Test
	public void fun3() throws Exception, IOException {
		Session session =MailUtils.createSession("smtp.163.com", "chen", "mima");
		Mail mail=new Mail("chen@163.com","xxx@qq.com","这是一封垃圾邮件","hello，world");
		AttachBean file=new AttachBean(new File("D://test.jpg"),"测试.jpg");
		mail.addAttach(file);
		MailUtils.send(session, mail);
	}
}

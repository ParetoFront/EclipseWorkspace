package cn.chen.tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag_3 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		Writer out=this.getJspContext().getOut();  //获取当前页面输出流
		out.write("********<br/>");
		this.getJspBody().invoke(out); //执行标签体内容，把结果写到指定的流中
		out.write("<br/>**********");
	}
}

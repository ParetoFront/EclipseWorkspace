package cn.chen.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag_2 extends SimpleTagSupport {
	@Override 
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("hello twice");
	}
}

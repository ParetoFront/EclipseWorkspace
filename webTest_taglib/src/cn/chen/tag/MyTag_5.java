package cn.chen.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag_5 extends SimpleTagSupport {
	private boolean test;

	// 该方法由tomcat调用，在dotag之前执行
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (test) {
			this.getJspBody().invoke(null);
		}
	}

}

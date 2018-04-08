package cn.chen.tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag_4 extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("只能看到我，下面什么都没有");
		throw new SkipPageException();//抛出异常后本页面下面部分不可见
	}

}

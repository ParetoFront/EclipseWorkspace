package cn.chen.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyTag implements SimpleTag{
	private PageContext pageContext;
	private JspFragment body;
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		pageContext.getOut().print("hello");
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		// TODO Auto-generated method stub
		this.body=body;
	}

	@Override
	public void setJspContext(JspContext arg0) {
		// TODO Auto-generated method stub
		this.pageContext=(PageContext) arg0;
	}

	@Override
	public void setParent(JspTag arg0) {}
	

}

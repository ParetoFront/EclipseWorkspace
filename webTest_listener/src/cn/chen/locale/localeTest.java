package cn.chen.locale;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class localeTest {
	@Test 
	public void fun1() {
		Locale locale=Locale.CHINA;
		ResourceBundle rb=ResourceBundle.getBundle("res",locale);
		System.out.println(rb.getString("username"));
	}
}

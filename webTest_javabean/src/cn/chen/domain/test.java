package cn.chen.domain;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class test {
	@Test
	public void fun1() throws Exception {
		Class cla=Class.forName("cn.chen.domain.Person");
		Object bean=cla.newInstance();
		BeanUtils.setProperty(bean, "name", "zhangsan");
		System.out.println(bean);
	}
}

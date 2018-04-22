package cn.chen.web.servlet;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
public class Base64Test {
	
	@Test
	public void fun() throws Exception {
		String s="Username";
		BASE64Encoder encoder=new BASE64Encoder();
		s=encoder.encode(s.getBytes("utf-8"));
		System.out.println(s);
		BASE64Decoder decoder=new BASE64Decoder();
		byte[] bys=decoder.decodeBuffer(s);
		System.out.println(new String(bys,"utf-8"));
	}
}

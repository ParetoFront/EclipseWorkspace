package iotest;

import java.io.*;

//复制图片
//数据流   d:\\a.jpg
//目的地   d:\\b.jpg
public class ImageIO {
	public static void main(String[] args) throws IOException {
		ImageIO ss=new ImageIO();
		String srcString="d://a.jpg";
		String destString="d://b.jpg";
		ss.copyImage(srcString, destString);
	}
	public void copyImage(String srcString,String destString) throws IOException {
		File src=new File(srcString);
		File dest=new File(destString);
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream(dest);
		int b;
		while((b=fis.read())!=-1) {
			fos.write(b);
		}
		fis.close();
		fos.close();
	}
}

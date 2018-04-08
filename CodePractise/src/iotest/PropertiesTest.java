package iotest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

//properties类是map的子类，它可以以io流为输入输出对象
public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		Properties pp=new Properties();
		Reader rr=new FileReader("a.txt");
		pp.load(rr);
		
		rr.close();
		
		System.out.println(pp);
	}
}

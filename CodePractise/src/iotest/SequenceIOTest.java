package iotest;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceIOTest {
public static void main(String[] args) throws IOException {
	FileInputStream fos=new FileInputStream("d://a.txt");
	FileInputStream fos2=new FileInputStream("d://b.txt");
	Vector<InputStream> list=new Vector<InputStream>(2);
	list.add(fos);
	list.add(fos2);
	Enumeration<InputStream> en=list.elements();
	SequenceInputStream sis=new SequenceInputStream(en);
	BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("d://d.txt"));
	int b;
	while((b=sis.read())!=-1) {
		bos.write(b);
		
	}
	bos.flush();
	bos.close();
	sis.close();
	
}
}

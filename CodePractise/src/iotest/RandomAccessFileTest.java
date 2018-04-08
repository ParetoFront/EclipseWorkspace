package iotest;
import java.io.*;

public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("a.txt","rw");
		char ch=raf.readChar();
		System.out.println(ch);
		raf.writeInt(88);
		raf.close();
	}
}

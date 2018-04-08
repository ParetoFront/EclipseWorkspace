package iotest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//将一个文档内的字符串内的字符排序，输出到另一个文档
public class SortString {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("a.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("b.txt"));
		String line=br.readLine();
		
		char[] chs=line.toCharArray();
		Arrays.sort(chs);
		String newStr=new String(chs);
		bw.write(newStr);
		
		
		bw.close();
		br.close();
	}
}

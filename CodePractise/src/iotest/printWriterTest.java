package iotest;
//打印流测试
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class printWriterTest {
	public static void main(String[] args) throws IOException {
		//获取数据源
		BufferedReader br=new BufferedReader(new FileReader("a.txt"));
		//封装目的地,设置自动刷新
		PrintWriter pw=new PrintWriter(new FileWriter("c.txt"),true);
		String line;
		while((line=br.readLine())!=null) {
			pw.println(line);
		}
		pw.close();
		br.close();
	}
}

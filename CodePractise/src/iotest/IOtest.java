package iotest;

import java.io.*;

//复制文本文件，字节流4种，字符流5种
//数据流   d:\\a.txt
//目的地   d:\\b.txt
public class IOtest {
	public static void main(String[] args) throws IOException {
		String srcString = "d:\\a.txt";
		String destString = "d:\\b.txt";
		IOtest ss = new IOtest();

		ss.method9(srcString, destString);
	}

	// 基本字节流----一次读写一个字节
	public void method1(String srcString, String destString) throws IOException {
		FileInputStream fis = new FileInputStream(srcString);
		FileOutputStream fos = new FileOutputStream(destString);
		int b = 0;
		while ((b = fis.read()) != -1) {
			fos.write(b);
		}
		fis.close();
		fos.close();
	}

	// 基本字节流---一次读写一个字节数组
	public void method2(String srcString, String destString) throws IOException {
		FileInputStream fis = new FileInputStream(srcString);
		FileOutputStream fos = new FileOutputStream(destString);
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = fis.read(bys)) != -1) {
			fos.write(bys, 0, len);
		}
		fis.close();
		fos.close();
	}

	// 字节缓冲流----一次读写一个字节
	public void method3(String srcString, String destString) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));
		int b;
		while ((b = bis.read()) != -1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
	}

	// 字节缓冲流---一次读写一个字节数组
	public void method4(String srcString, String destString) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}
		bis.close();
		bos.close();
	}

	// 基本字符流----一次一个字符
	public void method5(String srcString, String destString) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(srcString), "GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destString), "UTF-8");
		int ch = 0;
		while ((ch = isr.read()) != -1) {
			osw.write(ch);
		}
		isr.close();
		osw.close();
	}

	// 基本字符流-----一次一个字符数组
	public void method6(String srcString, String destString) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream(srcString), "GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destString), "UTF-8");
		char[] chs = new char[1024];
		int len;
		while ((len = isr.read(chs)) != -1) {
			osw.write(chs, 0, len);
		}
		isr.close();
		osw.close();
	}

	// 缓冲字符流-------一次一个字符
	public void method7(String srcString, String destString) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcString), "GBK"));
		// 简化写法,但是不能自主选择编码方式了
		// BufferedReader br = new BufferedReader(new FileReader(srcString));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destString), "UTF-8"));
		// BufferedWriter bw=new BufferedWriter(new FileWriter(destString));
		int ch;
		while ((ch = br.read()) != -1) {
			bw.write(ch);
		}
		br.close();
		
		bw.flush();
		bw.close();
	}
	// 缓冲字符流-------一次一个字符数组
		public void method8(String srcString, String destString) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcString), "GBK"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destString), "UTF-8"));
			char[] chs=new char[1024];
			int len;
			while ((len = br.read(chs)) != -1) {
				bw.write(chs,0,len);
			}
			
			br.close();
			bw.close();
		}
		//缓冲字符流-------一次读写一个字符串
		public void method9(String srcString, String destString) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcString), "GBK"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destString), "UTF-8"));
		String line;
		
			while((line=br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
//				bw.flush();
			}
			br.close();
			bw.close();
		}
}

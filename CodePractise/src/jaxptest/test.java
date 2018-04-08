package jaxptest;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		test ss=new test();
		ss.digui(5);
	}
	private void digui(int x) {
		if(x==1) {
			System.out.print(x);
		}else {
			System.out.print(x+"*");
			digui(x-1);
		}
	}
}

package P412_FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class P412_solution {
	public static void main(String[] args) {
		P412_solution ss=new P412_solution();
		System.out.println(ss.fizzbuzz(15));
	}
	private List<String> fizzbuzz(int n){
		List<String> arr=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(i%3==0&&i%5==0) {
				arr.add("fizzbuzz");
			}else if(i%3==0) {
				arr.add("fizz");
			}else if(i%5==0) {
				arr.add("buzz");
			}else{
				arr.add(String.valueOf(i));
			}
		}
		return arr;
	}
}

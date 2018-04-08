package P412_FizzBuzz;
//不用%

import java.util.ArrayList;
import java.util.List;

public class P412_solution2 {
	public static void main(String[] args) {
		P412_solution2 ss=new P412_solution2();
		System.out.println(ss.fizzbuzz(15));
	}
	private List<String> fizzbuzz(int n){
		int fizz=1;
		int buzz=1;
		List<String> arr=new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(fizz==3&&buzz==5) {
				arr.add("fizzbuzz");
			}else if(fizz==3) {
				arr.add("fizz");
			}else if(buzz==5) {
				arr.add("buzz");
			}else {
				arr.add(String.valueOf(i));
			}
			
			if(fizz==3) {
				fizz=0;
			}
			if(buzz==5) {
				buzz=0;
			}
			fizz++;
			buzz++;
		}
		return arr;
	}
}

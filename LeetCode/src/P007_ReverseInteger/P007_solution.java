package P007_ReverseInteger;

public class P007_solution {
	public static void main(String[] args) {
		P007_solution ss=new P007_solution();
		System.out.println(ss.reverse(134344420));
	}
	private int reverse(int x) {
		
		int result=0;
		while(x!=0) {
			int res=result;
			int temp=x%10;
			res=res*10+temp;
			//接下来判断是否有溢出，若有，则返回0
			if((res-temp)/10!=result) {
				return 0;
			}
			result=res;
			x=x/10;
		}
		return result;
	}
}

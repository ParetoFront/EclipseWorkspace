import org.junit.Test;
//求第n位的斐波那契数列
public class P009 {
	@Test
	public void fun() {
		System.out.println(getFibo(6));
		
	}
	public int getFibo(int n) {
		if(n<0) {
			return 0;
		}
		if(n==1||n==2) {
			return 1;
		}
		int prePre=1;
		int pre=1;
		int cur=2;
		for(int i=3;i<=n;i++) {
			cur=prePre+pre;
			prePre=pre;
			pre=cur;
		}
		return cur;
	}
	
}

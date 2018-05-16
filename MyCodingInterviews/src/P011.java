import org.junit.Test;

//求x的y次方
public class P011 {
	@Test
	public void fun() {
		System.out.println(getExpRes(2, 4));
	}

	public double getExpRes(double base, int exp) {
		if (base == 0) {
			if (exp <= 0) {
				throw new RuntimeException("您的输入不合法！");
			}
			return 0;
		}
		if(exp>0) {
			return getExp(base,exp);
		}else {
			return 1/getExp(base,-exp);
		}
	}
	//使用分治算法，效率更高
	private double getExp(double base, int exp) {
		if (exp == 0) {
			return 1;
		}
		if (exp == 1) {
			return base;
		}
		double res = getExp(base, exp >> 1);
		res *= res;
		if (exp % 2 != 0) {
			res *= base;
		}
		return res;
	}

}

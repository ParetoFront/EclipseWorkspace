package P014_LongestCommonPrefix;
//方法三：二分法，对strs[0]二分，先校验左半部分，若成功，则尝试加上右半部分的二分。若不成功，则对左半部分继续二分。

public class P014_solution_2 {
	public static void main(String[] args) {
		String[] strs = { "leet", "lee", "leets", "le" };
		P014_solution_2 ss=new P014_solution_2();
		System.out.println(ss.findCommon(strs));
	}
	private String findCommon(String[] strs) {
		int high=strs[0].length();   //注意high和low的取值
		int low=1;
		while(low<=high) {
			int mid=(low+high)/2;
			if(isCommon(strs, mid)) {
				low=mid+1;     //既然mid左侧的部分已经校验成功，那么新的low应超越mid
			}else {
				high=mid-1;     //既然mid左侧的部分校验失败，那么 mid所在那位失败，新的high不应包含mid
			}
		}
		return strs[0].substring(0, (low+high)/2);
	}

	private boolean isCommon(String[] strs, int len) {
		String sub = strs[0].substring(0, len);
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].indexOf(sub) != 0) {
				return false;
			}
		}
		return true;
	}
}

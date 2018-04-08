package P014_LongestCommonPrefix;

public class P014_solution {
	public static void main(String[] args) {
		P014_solution ss = new P014_solution();
		String[] strs = { "leet", "lee", "leets", "le" };
		System.out.println(ss.LCP(strs));
		System.out.println(ss.method2(strs));
	}

	// 方法一：从长到短，取strs[0]为假定LCP，与strs[i]比较,
	// 一旦有不符，则strs[0]去除最后一位，直到匹配.(因此要用while循环）
	// 匹配完后，选strs[i+1]。继续比较。
	private String LCP(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int n = strs[0].length();
		String sub = strs[0].substring(0, n - 1);
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(sub) != 0) {
				sub = sub.substring(0, sub.length() - 1);
				if (sub.isEmpty()) {
					return "";
				}
			}
		}
		return sub;
	}

	// 方法二：从短到长，选择strs[0]作为假定LCP，取其第一个字母，与strs[]比较，如成功，则再扩大一位
	// 若失败，则所有工作停止，返回已成功的substring。
	// 另外，substring非常耗时，尽量少用
	private String method2(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				// if (i == strs[j].length() || strs[j].indexOf(strs[0].substring(0, i+1)) != 0)
				// {
				if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	

}
package P005_LongestPalindromicString;

public class P005_solution {
	public static void main(String[] args) {
		System.out.println(new P005_solution().longestPalindrome("abaaa"));
	}

	public String longestPalindrome(String s) {

		if (s.length() < 2)
			return s;
		int start = 0, end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i); // 单个字母为中心的情况
			int len2 = expandAroundCenter(s, i, i + 1);// 两个相同字母为中心的情况
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) { // 以i（或是i与i+1）为中心开始扩张
			L--;
			R++;
		}
		return R - L - 1;
	}
}

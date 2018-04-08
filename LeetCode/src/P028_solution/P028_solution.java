package P028_solution;

public class P028_solution {
	public static void main(String[] args) {
		String haystack="hello";
		String needle="ll";
		P028_solution ss=new P028_solution();
		System.out.println(ss.strStr(haystack, needle));
	}
	public int strStr(String haystack, String needle) {
		for(int i=0;i<haystack.length()-needle.length()+1;i++) {
			for(int j=0; ;j++) {
				if(j==needle.length()) {
					return i;
				}
				if(haystack.charAt(i+j)!=needle.charAt(j)) {
					break;
				}
			}
		}
		return -1;
	}
}

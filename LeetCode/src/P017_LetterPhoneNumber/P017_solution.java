package P017_LetterPhoneNumber;

import java.util.LinkedList;
import java.util.List;

// 拨号盘   1       2(abc)  3(def)
//        4(ghi)  5(jkl)  6(mno)
//        7(pqrs) 8(tuv)  9(wxyz)
//         *       0       #

public class P017_solution {
	public static void main(String[] args) {
		P017_solution ss=new P017_solution();
		System.out.println(ss.LetterCombination("12"));
	}

	private List<String> LetterCombination(String digits) {
		LinkedList<String> res = new LinkedList<>();
		if(digits.length()==0) {
			return res;
		}
		res.add("");
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		for (int i = 0; i < digits.length(); i++) {
			int num = Character.getNumericValue(digits.charAt(i));
			while (res.peek().length() == i) {
				String t = res.remove();
				for (char ch : mapping[num].toCharArray()) {
					res.add(t + ch);
				}
			}
		}
		return res;
	}
}

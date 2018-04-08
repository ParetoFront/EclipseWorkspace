package P020_ValidParentheses;

//String s只由()[]{}组成，判断其是否合法
//solution2是改进版
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class P020_solution {
	public static void main(String[] args) {
		P020_solution ss = new P020_solution();
		String s = "({{[]}})";
		System.out.println(ss.isValid(s));
	}

	public boolean isValid(String s) {

		ArrayList<Character> arr1 = new ArrayList<>();
		arr1.add('(');
		arr1.add('[');
		arr1.add('{');
		ArrayList<Character> arr2 = new ArrayList<>();
		arr2.add(')');
		arr2.add(']');
		arr2.add('}');

		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (arr1.contains(s.charAt(i))) {
				list.push(s.charAt(i));
			} else {
				if (list.isEmpty() || list.pop() != arr1.get(arr2.indexOf(s.charAt(i)))) {
					return false;
				}
			}
		}
		return true;
	}
}

package P013_RomanInteger;
//罗马转整数的问题在于罗马数字有时是二个字母组成一位数字，将这样的两个字母分开处理即可。
//正因为罗马数字的这一特性，也无法像整数转罗马那样用while循环遍历，需要建立可以直接查询的对应表。
//即要实现“找到单个（或两个）罗马数字对应的整数”
//实现这一功能，有两种方式，一是hashmap，二是switch...case
import java.util.HashMap;

public class P013_solution {
	public static void main(String[] args) {
		P013_solution ss = new P013_solution();
		System.out.println(ss.romanToInt("MMMIX"));
	}

	private int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res += map.get(s.charAt(i));
			if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
				res -= 2 * map.get(s.charAt(i - 1));
			}
		}
		return res;
	}

	// 第二种方法
	private int method2(String s) {
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			switch (c) {
			case 'I':
				res += (res >= 5 ? -1 : 1);
				break;
			case 'V':
				res += 5;
				break;
			case 'X':
				res += 10 * (res >= 50 ? -1 : 1);
				break;
			case 'L':
				res += 50;
				break;
			case 'C':
				res += 100 * (res >= 500 ? -1 : 1);
				break;
			case 'D':
				res += 500;
				break;
			case 'M':
				res += 1000;
				break;
			}
		}
		return res;

	}
}

package P012_IntegerRoman;

//抓住转变的节点，事实上罗马数字由roman[]中的节点组成
public class P012_solution_2 {
	public static void main(String[] args) {
		P012_solution_2 ss = new P012_solution_2();
		System.out.println(ss.intToRoman(3009));
	}

	private String intToRoman(int num) {
		int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (num > 0) {
			if (num >= value[i]) {
				sb.append(roman[i]);
				num -= value[i];
			} else {
				i++;
			}
		}
		return sb.toString();
	}
}

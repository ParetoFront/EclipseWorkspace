package P022_GenerateParentheses;
//递归
import java.util.ArrayList;
import java.util.List;

public class P022_solution {
	public static void main(String[] args) {
		P022_solution ss=new P022_solution();
		System.out.println(ss.generateparentheses(3));
	}
	private List<String> generateparentheses(int n) {
		List<String> list = new ArrayList<>();
		generator(list, n, n, "");
		return list;
	}

	private void generator(List<String> list, int leftNum, int rightNum, String res) {
		if (leftNum == 0 && rightNum == 0) {
			list.add(res);
			return;
		}
		if (leftNum > 0) {
			generator(list, leftNum - 1, rightNum, res + "(");
		}
		if (leftNum < rightNum) {
			generator(list, leftNum, rightNum - 1, res + ")");
		}
	}
}

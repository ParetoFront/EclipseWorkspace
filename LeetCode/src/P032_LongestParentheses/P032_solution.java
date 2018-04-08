package P032_LongestParentheses;
//使用栈的方法，预先压入-1
//若遇到‘（’，则将index压入栈。这意味着这是目前视为非法的字符位置，今后若遇‘）’则弹出
//若遇到‘）’，则弹出栈顶元素，表示一对（）抵消，紧接着做判断：
//        ====》若此时栈已空，表示已经没有滞留‘（’，没有剩余的‘（’来与当前‘）’抵消，
//              合法字符串至此中断，直接将i压入。（合法字符串的长度已经存入maxlen）
//        ====》若此时栈不空，则maxlen = Math.max(maxlen, i - stack.peek())
import java.util.Stack;

public class P032_solution {
	public static void main(String[] args) {
		P032_solution ss=new P032_solution();
		System.out.println(ss.longestParentheses("(()()"));
	}
	private int longestParentheses(String s) {
		int maxlen = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();    
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					maxlen = Math.max(maxlen, i - stack.peek());
				}
			}
		}
		return maxlen;
	}
}

package P020_ValidParentheses;

import java.util.Stack;

public class P020_solution2 {
	public static void main(String[] args) {
		P020_solution2 ss=new P020_solution2();
		String s="({[{}]})";
		System.out.println(ss.isValid(s));;
	}
	
	public boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for(char ch:s.toCharArray()) {
			if(ch=='(') {
				stack.push(')');   //精妙之处在于检测到“ ( ” 时压入“ ) ”
			}else if(ch=='[') {
				stack.push(']');
			}else if(ch=='{') {
				stack.push('}');
			}else if(stack.isEmpty()||stack.pop()!=ch) {
				return false;
			}
		}
		return true;
	}
}

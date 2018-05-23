import java.util.Stack;

import org.junit.Test;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1 、2、3 、4、5 是某栈压栈序列，
 * 序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
 * 但4、3、5、1、2就不可能是该压棋序列的弹出序列。
 */
public class P021 {
	@Test
	public void fun() {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 5, 2,3, 1 };
		System.out.println(isPopOrder(push, pop));
	}

	public boolean isPopOrder(int[] push, int[] pop) {
		if (push == null || pop == null || pop.length != push.length) {
			return false;
		}
		// push中元素依次入栈，如遇到与pop中相同元素则出栈，最后校验栈是否为空
		Stack<Integer> stack = new Stack<Integer>();
		int pushIndex = 0;
		int popIndex = 0;
		while (popIndex < pop.length) { // 若还有出栈元素未处理
			while (pushIndex < push.length 
					&& (stack.isEmpty() || stack.peek() != pop[popIndex])) {
				stack.push(push[pushIndex]);
				pushIndex++;
			}
			if (stack.peek() == pop[popIndex]) {
				stack.pop();
				popIndex++;
			} else {
				return false;
			}
		}
		return true;

	}
}

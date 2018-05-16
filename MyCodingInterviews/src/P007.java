import java.util.Stack;

import org.junit.Test;

//用两个栈模拟队列的先进先出，如appendTail和getHead
public class P007 {
	@Test
	public void fun() {
		MyQueue q = new MyQueue();
		q.appendTail(1);
		q.appendTail(2);
		q.appendTail(3);

		q.print();
		q.deleteHead();
		q.deleteHead();
		q.print();
	}

	public class MyQueue {
		private Stack<Integer> s1 = new Stack<>(); // 用于压入数据
		private Stack<Integer> s2 = new Stack<>(); // 用于弹出数据

		public void appendTail(int x) {
			if (s2.isEmpty()) {
				s1.push(x);
			} else {
				while (!s2.isEmpty()) {
					s1.push(s2.pop());
				}
				s1.push(x);
			}
		}

		public int deleteHead() {

			if (s2.isEmpty()) {
				if (s1.isEmpty()) {
					throw new RuntimeException("队列为空！");
				}
				while (!s1.isEmpty()) {
					s2.push(s1.pop());
				}
				return s2.pop();
			} else {
				return s2.pop();
			}
		}

		public void print() {

			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}

			while (!s2.isEmpty()) {
				int tmp=s2.pop();
				s1.push(tmp);
				System.out.print(tmp + " ");
			}
		}
	}
}

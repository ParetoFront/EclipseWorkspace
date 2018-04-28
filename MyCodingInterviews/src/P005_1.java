import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

//输入一个链表，从尾到头打印链表每个节点的值
//思路：将链表正序遍历存到栈中，栈依次弹出
public class P005_1 {
	@Test
	public void fun() {
		ListNode target=new ListNode(1);
		ListNode start=target;
		target.next=new ListNode(2);
		target=target.next;
		target.next=new ListNode(3);
		System.out.println(printListFromTailToHead(start));
	}
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack=new Stack<Integer>();  //创建堆栈
		ArrayList<Integer> list=new ArrayList<>();
		if(listNode==null) {
			return list;
		}
		//遍历链表，存入栈中
		while(listNode!=null) {
			stack.push(listNode.val);
			listNode=listNode.next;
		}
		//遍历栈，存入list
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}
	
} 



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//使用递归，每当节点有下一个节点，则先打印下一个节点
public class P005_2 {
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
		ArrayList<Integer> list=new ArrayList<>();
		goNext(listNode,list);
		return list;
	}
	private void goNext(ListNode listNode,List list) {
		if(listNode.next!=null) {
			goNext(listNode.next,list);
		}
		list.add(listNode.val);
	}
}

package P023_MergeKList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;



public class P023_solution {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(5);l2.next.next = new ListNode(7);
		ListNode[] lists= {l1,l2,l3};
		P023_solution ss=new P023_solution();
		ListNode result=ss.mergeKLists(lists);
		while(result!=null) {
			System.out.println(result.val);
			result=result.next;
		}
	}
	
	
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0||lists==null) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
			@Override         //重写comparator方法
			public int compare(ListNode o1, ListNode o2) {
				return o1.val-o2.val;
//				if (o1.val < o2.val) {
//					return -1;
//				} else if (o1.val == o2.val) {
//					return 0;
//				} else {
//					return 1;
//				}
			}
		});
		ListNode res=new ListNode(0);
		ListNode test=res;
		for(ListNode obj:lists) {
			if(obj!=null) {
				queue.add(obj);
			}
		}
		while(!queue.isEmpty()) {
			test.next=queue.poll();
			test=test.next;
			
			if(test.next!=null) {        //将被提取了一个头节点的链表的新头结点重新注入queue
				queue.add(test.next);
			}
		}
		return res.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
package P019_RemoveNode;
//移除某链表的倒数第n个节点，将新的链表返回
//预备：定义ListNode类
//第一步：遍历链表，得到长度
//第二部：重新遍历链表至倒数第n个节点，除去之

public class P019_solution {
	private ListNode removement(ListNode head, int n) {
		if(head==null) {
			return null;
		}
		if(n==0) {
			return head;
		}
		ListNode result=new ListNode(0);
		result.next=head;
		ListNode first=head;
		
		int length=0;
		while(first!=null) {
			length++;
			first=first.next;
		}
		length-=n;
		first=result;
		while(length!=0) {
			length--;
			first=first.next;
		}
		first.next=first.next.next;
		return result.next;
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
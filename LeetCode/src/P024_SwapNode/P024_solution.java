package P024_SwapNode;
// 节点操作的关键在于分清两种类型的操作：
// cur=cur.next类型：cur的指向的节点变了，其next也跟着变了
// cur.next=temp类型：cur的下一节点产生变化，但cur本身指向的节点不变

public class P024_solution {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode start=head;
		head.next = new ListNode(2);
		head = head.next;
		head.next = new ListNode(3);
		head = head.next;
		head.next = new ListNode(4);
		
		P024_solution ss = new P024_solution();
		ListNode res = ss.swapPairs(start);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode newHead = head.next; // 新链表的头结点为节点2
		while (cur != null && cur.next != null) {
		
			ListNode temp = cur; // temp指向节点1
			cur = cur.next; // cur转而指向节点2
			temp.next = cur.next; // 节点1的next为节点3
			cur.next = temp; // 节点2的next为节点1
			cur = temp.next; // cur指向节点3
			if (cur != null && cur.next != null) {
				temp.next = cur.next;
				// 非常重要的一步，令节点1的下一节点为节点4.
				// 若无此步，上述程序仅仅实现了一组节点互换，组与组之间却没有连接
			}
			
		}
		return newHead;
	}
}

class ListNode {
	ListNode next;
	int val;

	ListNode(int x) {
		val = x;
	}
}
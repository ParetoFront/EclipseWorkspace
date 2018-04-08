package P021_MergeTwoList;

public class P021_solution {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		P021_solution ss = new P021_solution();
		ListNode out = ss.mergeTwoLists(l1, l2);
		while (out != null) {
			System.out.print(out.val + "---");
			out = out.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1; // 返回的仍是头部
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
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
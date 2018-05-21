import java.util.Stack;

import org.junit.Test;

//输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
public class P017 {
	@Test
	public void fun() {
		ListNode head1 = new ListNode(1);
		ListNode tmp = head1;
		int i = 1;
		while (i < 5) {
			tmp.next = new ListNode(2 * i);
			tmp = tmp.next;
			i++;
		}
		i = 1;
		ListNode head2 = new ListNode(2);
		tmp = head2;
		while (i < 5) {
			tmp.next = new ListNode(3 * i);
			tmp = tmp.next;
			i++;
		}

		ListNode res = mergeTwoList(head1, head2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}

	public ListNode mergeTwoList(ListNode head1, ListNode head2) {
		while (head1 == null)
			return head2;
		while (head2 == null)
			return head1;
		ListNode newHead = new ListNode();
		ListNode tmp = newHead;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				newHead.next = head1;
				newHead = newHead.next;
				head1 = head1.next;
			} else {
				newHead.next = head2;
				head2 = head2.next;
				newHead = newHead.next;
			}
		}
		if (head1 != null)
			newHead.next = head1;
		if (head2 != null)
			newHead.next = head2;
		return tmp.next;
	}

	/*
	 * 使用尾递归
	 */
	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode newHead = new ListNode(1);
		ListNode tmp = newHead;
		merge2(head1, head2, tmp);
		return newHead.next;
	}

	public ListNode merge2(ListNode head1, ListNode head2, ListNode newHead) {
		if (head1 == null) {
			newHead.next = head2;
			return newHead;
		}
		if (head2 == null) {
			newHead.next = head1;
			return newHead;
		}

		if (head1.val < head2.val) {
			newHead.next = head1;
			return merge2(head1.next, head2, newHead.next);
		} else {
			newHead.next = head2;
			return merge2(head1, head2.next, newHead.next);
		}

	}

}

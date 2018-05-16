import org.junit.Test;

/*
 * 要求：给出链表头结点，删除某一指定节点
 */
public class P013 {

	@Test
	public void fun() {
		ListNode head = new ListNode(1);
		ListNode tmp = head;
		for (int i = 2; i < 10; i++) {
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		ListNode target = head.next.next.next;
		ListNode res = deleteNode(head, target);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public ListNode deleteNode(ListNode head, ListNode target) {
		if (head == null || target == null) {   
			throw new RuntimeException("invalid input!");
		}
		if (head == target) {   //若为头结点则直接返回头结点下一节点
			return head.next;
		}

		if (target.next == null) {   //若删除目标为尾节点
			ListNode tmp = head;
			while (tmp.next != target) {
				tmp = tmp.next;
			}
			tmp.next = null;
		} else {
			ListNode tmp = head;
			while (tmp.next != target) {
				tmp = tmp.next;
			}

			tmp.next = target.next;
		}
		return head;
	}
}

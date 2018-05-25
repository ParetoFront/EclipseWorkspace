import org.junit.Test;

//翻转链表,返回新的头结点
public class P016 {
	@Test
	public void fun() {
		ListNode head = new ListNode(1);
		ListNode tmp = head;
		for (int i = 2; i < 6; i++) {
			tmp.next = new ListNode(i);
			tmp = tmp.next;
		}
		ListNode newHead = reverse(head);
		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
		
	}

	/*
	 * 递归实现,详见onenote笔记
	 */
	public ListNode reverseList2(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode preNode=reverseList2(head.next);  //preHead永远指向节点5
		head.next.next=head;  //例如当前head为节点4，则此操作的效果为4->5->4
		head.next=null;      //断开4->5,只剩下5->4
		return preNode;     //返回preHead，此时preHead的内容为5->4
	}
	/*
	 * 迭代实现
	 */
	public ListNode reverseList(ListNode head) {

		ListNode newHead=null;
		ListNode tmp;
		while (head != null) {
			tmp = head.next;   //接下来要对当前节点进行操作，先保存后续内容以防丢失
			
			head.next = newHead;  //关键两步，先将newHead连接到当前节点尾部
			newHead = head;  //第二步：更新newHead
			
			head = tmp;   //更新当前节点，即当前节点移到下一节点
		}
		return newHead;
	}

}

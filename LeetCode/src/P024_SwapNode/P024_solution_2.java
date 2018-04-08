package P024_SwapNode;
// 使用递归
public class P024_solution_2 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode start=head;
		head.next = new ListNode(2);
		head = head.next;
		head.next = new ListNode(3);
		head = head.next;
		head.next = new ListNode(4);
		
		P024_solution_2 ss = new P024_solution_2();
		ListNode res = ss.dfs_method(start);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	private ListNode dfs_method(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		ListNode nextNode=head.next;
		head.next=dfs_method(nextNode.next);
		nextNode.next=head;
		return nextNode;
	}
}
//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x){
//		val=x;
//		next=null;
//	}
//}
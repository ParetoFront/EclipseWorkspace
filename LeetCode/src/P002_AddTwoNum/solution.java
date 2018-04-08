package P002_AddTwoNum;

//关键在与怎样处理不同长度的数字相加
public class solution {
	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		int carry = 0;
		ListNode res = new ListNode(0); // 首个节点为0
		ListNode start=res;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			res.next = new ListNode(sum % 10);
			res = res.next;
			if(l1!=null) l1=l1.next;
			if(l2!=null) l2=l2.next;
		}
		if(carry!=0) res.next=new ListNode(carry);
		return start.next;
	}
}

class ListNode {
	ListNode next;
	int val;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
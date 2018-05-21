import org.junit.Test;

//返回倒数第k个节点
public class P015 {
	@Test
	public void fun() {
		ListNode head=new ListNode(1);
		ListNode tmp=head;
		for(int i=2;i<6;i++) {
			tmp.next=new ListNode(i);
			tmp=tmp.next;
		}
		System.out.println(findNode(head,1).val);
	}
	public ListNode findNode(ListNode head,int k) {
		if(head==null) {
			return head;
		}
		int index=0;
		ListNode leftNode=head,rightNode=head;
		
		while(index<k) {
			if(rightNode.next==null) {
				throw new RuntimeException("invalid input");
			}
			rightNode=rightNode.next;
			index++;
		}
		while(rightNode.next!=null) {
			rightNode=rightNode.next;
			leftNode=leftNode.next;
		}
		return leftNode;
	}
}

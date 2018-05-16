package P094_TreeInorderTravel;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * 用堆栈实现中序遍历
 * 中序遍历要求左根右的顺序，则首先已知选择左孩子一次压入栈中（注意，这一过程同时将沿途的根节点和左孩子都压入栈中了）
 * 再一次弹出节点，每弹出一个节点（这个节点既是父节点的左孩子，本身也是父节点），就先切换到当前节点的右孩子，实现了左根右的顺序
 */


public class P094_solution2 {
	public List<Integer> TreeInorderTravel(TreeNode t) {
		List<Integer> res=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<>();
		TreeNode cur=t;
		while(cur!=null||!stack.isEmpty()) {
			while(cur.left!=null) {
				stack.push(cur);  //将当前节点压入栈中，它既是根节点，又是左孩子
				cur=cur.left;   //沿着左孩子的路线继续压栈
			}
			TreeNode tmp=stack.pop();  //弹出一个节点，即最左的左孩子
			res.add(tmp.val);   //处理的既是左孩子，同时也是根节点
			cur=cur.right;  //左孩子和父节点均已处理处理右孩子
		}
		return res;
	}
}

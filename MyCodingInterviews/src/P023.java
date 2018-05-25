import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
//按层打印一颗二叉树，每层从左往右打印
public class P023 {
	@Test
	public void fun() {
		TreeNode root=new TreeNode(8);
		TreeNode.insert(root, 6);
		TreeNode.insert(root, 5);
		TreeNode.insert(root, 7);
		TreeNode.insert(root, 10);
		TreeNode.insert(root, 9);
		TreeNode.insert(root, 11);
		printRootNode(root);
		
	}
	public void printRootNode(TreeNode root) {
		if(root!=null) {
			Queue<TreeNode> list=new LinkedList<TreeNode>();
			list.add(root);
			TreeNode tmp;
			while(!list.isEmpty()) {
				tmp=list.remove();
				System.out.println(tmp.val);
				if(tmp.left!=null) list.add(tmp.left);
				if(tmp.right!=null) list.add(tmp.right);
			}
		}
	}
}

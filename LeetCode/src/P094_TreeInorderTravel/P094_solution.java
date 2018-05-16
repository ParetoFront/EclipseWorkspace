package P094_TreeInorderTravel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//要求：中序遍历二叉树
//用递归方法实现
public class P094_solution {
	public List<Integer> TreeInorderTravel(TreeNode t) {
		List<Integer> res = new ArrayList<Integer>();
		if (t != null) {
			fun(t, res);
		}
		return res;
	}

	private void fun(TreeNode root, List<Integer> res) {
		if (root.left != null) {
			fun(root.left, res);
		}
		res.add(root.val);
		if (root.right != null) {
			fun(root.right, res);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}
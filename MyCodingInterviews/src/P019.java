import org.junit.Test;

/*
 * 翻转二叉树
 */
public class P019 {
	@Test
	public void fun() {
		TreeNode root=new TreeNode(8);
		TreeNode.insert(root, 6);
		TreeNode.insert(root, 5);
		TreeNode.insert(root, 7);
		TreeNode.insert(root, 10);
		TreeNode.insert(root, 9);
		TreeNode.insert(root, 11);
		TreeNode.printTree(root);
		reverse(root);
		TreeNode.printTree(root);
	}
	
	public void reverse(TreeNode root) {
		if(root!=null) {
			TreeNode tmp=root.left;
			root.left=root.right;
			root.right=tmp;
			
			reverse(root.left);
			reverse(root.right);
		}
	}
}

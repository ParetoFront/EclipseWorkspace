/*
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
 * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
 * 否则直到所有的结点都找完为止。
 */
public class P018 {
	public boolean hasSubTree(TreeNode t1,TreeNode t2) {
		if(t2==null) return true;
		if(t1==null) return false;   //t1的判断应该在t2判断的后面
		
		boolean res=false;
		if(t1.val==t2.val) {
			res=isMatch(t1,t2);
		}
		if(res) return true;
		return isMatch(t1.left,t2) || isMatch(t1.right,t2);
	}

	private boolean isMatch(TreeNode t1, TreeNode t2) {
		if(t2==null) return true;
		if(t1==null) return false;
		
		if(t1.val==t2.val) {
			return isMatch(t1.left,t2.left)&&isMatch(t1.right,t2.right);
		}
		return false;
	}
}

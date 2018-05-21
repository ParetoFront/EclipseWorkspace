
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val=x;
	}
	public static void insert(TreeNode t,int x) {
		if(x>t.val) {
			if(t.right==null) {
				t.right=new TreeNode(x);
			}else {
				insert(t.right,x);
			}
			
		}else if(x<t.val) {
			if(t.left==null) {
				t.left=new TreeNode(x);
			}else {
				insert(t.left,x);
			}
		}else {
			
		}
	}
	 public static void printTree(TreeNode node) {
	        if (node != null) {
	            printTree(node.left);
	            System.out.print(node.val + " ");
	            printTree(node.right);
	        }
	    }
}

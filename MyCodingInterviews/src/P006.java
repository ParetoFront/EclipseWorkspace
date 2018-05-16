import org.junit.Test;
//由前序遍历和中序遍历还原二叉树
public class P006 {
	
	public TreeNode construct(int[] preorder, int[] inorder) {
		// 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
		if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {
			return null;
		}

		return constructor(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}


	public TreeNode constructor(int[] preOrder,int ps,int pe,int[] inOrder,int is,int ie) {
		if(ps>pe) {      //若ps>pe，则表明已经遍历完所有节点
			return null;
		}
		int value=preOrder[ps];   //由前序遍历获取根节点的值
		int index=is;
		while(inOrder[index]!=value) {   //遍历找到根节点在中序遍历中的位置
			index++;
		}
		TreeNode root=new TreeNode(value);
		//index-is是由中序遍历得到的左子树的节点数
		root.left=constructor(preOrder, ps+1, ps+index-is, inOrder, is, index-1);
		root.right=constructor(preOrder, ps+index-is+1, pe, inOrder, index+1, ie);
		return root;
	}
}

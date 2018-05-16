import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 类型 T 必须实现 Comparable 接口，并且这个接口的类型是 T 或 T 的任一父类
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BinaryNode<Integer> root = tree.insert(5, null);
		tree.insert(3, root);
		tree.insert(4, root);
		tree.insert(6, root);
		tree.insert(9, root);
		tree.insert(2, root);
		tree.root=root;
		printTreeAll(tree.root);
		System.out.println(tree.contains_while(2, tree.root));
		
	}

	/*
	 * 节点定义
	 */
	private static class BinaryNode<T> {
		Object element;
		BinaryNode<T> left;
		BinaryNode<T> right;

		BinaryNode(T ele) {
			this(ele, null, null);
		}

		BinaryNode(T ele, BinaryNode<T> left, BinaryNode<T> right) {
			this.element = ele;
			this.left = left;
			this.right = right;
		}
	}

	/*
	 * 二叉查找树成员变量
	 */
	private BinaryNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	/*
	 * 二叉树的赋值方法
	 */
	public BinaryNode<T> insert(T obj, BinaryNode<T> root) {
		if (root == null) {
			return new BinaryNode(obj, null, null);
		}
		int cmpRes = obj.compareTo((T) root.element);
		if (cmpRes < 0) {
			root.left = insert(obj, root.left);
		} else if (cmpRes > 0) {
			root.right = insert(obj, root.right);
		} else {
			// 说明是重复值，什么也不做
		}
		return root;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(T obj) {
		return contains(obj, root);
	}

	private boolean contains(T obj, BinaryNode<T> root) {
		if (root == null)
			return false;
		int compareRes = obj.compareTo((T) root.element);
		if (compareRes < 0) {
			return contains(obj, root.left);
		} else if (compareRes > 0) {
			return contains(obj, root.right);
		} else {
			return true;
		}
	}

	/*
	 * 用while循环实现contains
	 */
	private boolean contains_while(T obj, BinaryNode<T> root) {
		while (root != null) {
			int compareRes = obj.compareTo((T) root.element);
			if (compareRes < 0) {
				root = root.left;
			} else if (compareRes > 0) {
				root = root.right;
			} else {
				return true;
			}

		}
		return false;
	}
	/*
	 * 查找最大节点
	 */
	public BinaryNode<T> finMax(BinaryNode<T> root) {
		if(root==null) return null;
		while(root.right!=null) {
			root=root.right;
		}
		return root;
	}
	/*
	 * 查找最小节点
	 */
	public BinaryNode<T> finMin(BinaryNode<T> root){
		if(root==null) return null;
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}
	public BinaryNode<T> remove(T obj,BinaryNode<T> root){
		if(root==null) return root;
		int cmp=obj.compareTo((T) root);
		if(cmp<0) {
			root.left=remove(obj,root.left);
		}else if(cmp>0) {
			root.right=remove(obj,root.right);
		}else if(root.left!=null&&root.right!=null) {  //找到目标节点，并且该节点有两个孩子
			root.element=finMin(root.right);
			root.right=remove((T) root.element,root.right);
		}else {          //找到目标节点，并且该节点只有一个孩子,则将有孩子一侧的剩余节点续上
			root=(root.left!=null)?root.left:root.right;
		}
		return root;
	}
	/*
	 * 由上至下打印二叉树
	 * 使用队列存储当前节点的左孩子右孩子，先进先出，一层一层打印
	 */
	public static void printTreeAll(BinaryNode<Integer> root) {
//		List<String> res=new ArrayList<String>();
		Queue<BinaryNode<Integer>> queue=new LinkedList<BinaryNode<Integer>>();
		queue.add(root);  //将第一层放入队列
		while(!queue.isEmpty()) {
			BinaryNode temp=queue.remove();
			
			System.out.println(temp.element);
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
		
	}
	
}

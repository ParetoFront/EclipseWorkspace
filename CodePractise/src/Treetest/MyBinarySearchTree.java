package Treetest;

public class MyBinarySearchTree<Object extends Comparable<Object>> {
	// BinaryTree内部类
	private static class MyBinaryNode<Object> {
		Object element;
		MyBinaryNode left;
		MyBinaryNode right;

		MyBinaryNode(Object o) {
			this.element = o;
			this.left = null;
			this.right = null;
		}

		public MyBinaryNode(Object element, MyBinaryNode left, MyBinaryNode right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}

	// 创建根节点
	private MyBinaryNode<Object> root;

	public MyBinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(Object o) {
		return contains(o, root);
	}

	public Object findMin() throws Exception {
		if (isEmpty()) {
			throw new Exception();
		}
		return findMin(root).element;
	}

	public Object findMax() throws Exception {
		if (isEmpty()) {
			throw new Exception();
		}
		return findMax(root).element;
	}
	public void insert(Object o) {
		root=insert(o,root);
	}
	public void remove(Object o) {
		root=remove(o,root);
	}
	public void printTree() {
		if(isEmpty()) {
			System.out.println("Empty Tree");
		}else {
			printTree(root);
		}
		
	}
	private boolean contains(Object o, MyBinaryNode t) {
		if(t==null) return false;
		int CompareResult=o.compareTo((Object) t.element);
		if(CompareResult>0) {
			return contains(o,t.right);
		}else if(CompareResult<0) {
			return contains(o,t.left);
		}else {
			return true;
		}
	}

	private MyBinaryNode<Object> findMin(MyBinaryNode<Object> t) {
		if(t==null) {
			return null;
		}else if(t.left==null){
			return t;
		}else {
			return findMin(t.left);
		}
	}

	private MyBinaryNode<Object> findMax(MyBinaryNode<Object> t) {
		if(t==null) {
			return null;
		}else if(t.right==null) {
			return t;
		}else {
			return findMax(t.right);
		}
	}
	private MyBinaryNode<Object> insert(Object o,MyBinaryNode<Object> t){
		if(t==null) {
			return new MyBinaryNode(o,null,null);
		}
		int compareResult=o.compareTo(t.element);
		if(compareResult>0) {
			t.right=insert(o,t.right);   //这一行实现了赋值操作，将新点连接到树上
		}else if(compareResult<0) {
			t.left=insert(o,t.left);
		}else {
		              	//重复元素，空过
		}
		return t;
	}
	private MyBinaryNode<Object> remove (Object o,MyBinaryNode<Object> t){
		if(t==null) {
			return t;
		}
		int compareResult=o.compareTo(t.element);
		if(compareResult>0) {
			t.right=remove(o,t.right);    //往右孩子搜索
		}else if(compareResult<0) {
			t.left=remove(o,t.left);      //往左孩子搜索
		}else if(t.left!=null&&t.right!=null) {    //左右孩子都有的情况
			t.element=(Object) findMin(t.right).element; //将本节点用右孩子中最小的元素代替（也可以用左孩子中最大的元素）
			t.right=remove(t.element,t.right);   //现在删除操作的目标变成右孩子中最小元素
		}else {
			t=(t.left!=null)?t.left:t.right;     //t中元素与o相等，则续上他的孩子（之前的判断已经表明t有且只有一个孩子）
		}
		return t;    //未找到目标元素，无删除操作
	}
	private void printTree(MyBinaryNode<Object> t) {
		if(t!=null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
}

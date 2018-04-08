package Treetest;

public class test {
	public static void main(String[] args) {
		MyBinarySearchTree<Integer> tree=new MyBinarySearchTree<Integer>();
		tree.insert(6);
		tree.insert(2);
		tree.insert(8);
		tree.insert(1);
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.printTree();
		tree.remove(2);
		tree.printTree();
	}
}

package com.sree.leave.programs.datastructures.tree;

public class FindIdenticalTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Tree tree = new Tree();
	        tree.root = new TreeNode(1);
	        tree.root.leftChild = new TreeNode(2);
	        tree.root.rightChild = new TreeNode(3);
	        tree.root.leftChild.leftChild = new TreeNode(4);
	        tree.root.leftChild.rightChild = new TreeNode(5);
	        
	        Tree tree2 = new Tree();
	        tree2.root = new TreeNode(1);
	        tree2.root.leftChild = new TreeNode(2);
	        tree2.root.rightChild = new TreeNode(3);
	        tree2.root.leftChild.leftChild = new TreeNode(4);
	        tree2.root.leftChild.rightChild = new TreeNode(5);
	       System.out.println(isIdentical(tree.root, tree2.root));
	}
	
	public static boolean isIdentical(TreeNode root1, TreeNode root2){
		if(null == root1 && null == root2){
			return true;
		}if(null!=root1 && null!=root2){
			return (root1.data == root2.data) && isIdentical(root1.leftChild, root2.leftChild)&& isIdentical(root1.rightChild, root2.rightChild);
		}
		return false;
		
	}

}

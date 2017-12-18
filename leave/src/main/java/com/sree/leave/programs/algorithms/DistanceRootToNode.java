package com.sree.leave.programs.algorithms;

/*
 * http://algorithms.tutorialhorizon.com/find-the-distance-from-root-to-given-node-of-a-binary-tree/
 */
public class DistanceRootToNode {

	public int Pathlength(final Node root, final int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;
	}

	public static void main(final String[] args) throws java.lang.Exception {
		final Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		final DistanceRootToNode i = new DistanceRootToNode();
		System.out.println("Distance from root to 45 is : " + (i.Pathlength(root, 45) - 1));
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(final int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

package com.sree.leave.programs.algorithms;

/*
 * http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/
 */
public class PrintDistance {
	public int findDistance(final Node root, final int n1, final int n2) {
		final int x = Pathlength(root, n1) - 1;
		final int y = Pathlength(root, n2) - 1;
		final int lcaData = findLCA(root, n1, n2).data;
		final int lcaDistance = Pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public int Pathlength(final Node root, final int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
				// System.out.println(root.data);
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public Node findLCA(final Node root, final int n1, final int n2) {
		if (root != null) {
			if (root.data == n1 || root.data == n2) {
				return root;
			}
			final Node left = findLCA(root.left, n1, n2);
			final Node right = findLCA(root.right, n1, n2);

			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
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
		final PrintDistance i = new PrintDistance();
		System.out.println("Distance between 45 and 20 is : " + i.findDistance(root, 45, 20));
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(final int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}



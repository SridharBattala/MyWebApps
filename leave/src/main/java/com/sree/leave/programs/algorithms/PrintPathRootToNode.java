package com.sree.leave.programs.algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class PrintPathRootToNode {

	public static ArrayList path;

	public Boolean printPath(final Node root, final Node dest) {
		if (root == null)
			return false;
		if (root == dest || printPath(root.left, dest) || printPath(root.right, dest)) {
			// System.out.print(" " + root.data);
			path.add(root.data);
			return true;
		}
		return false;
	}

	public static void main(final String[] args) throws java.lang.Exception {
		final Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		final Node n1 = new Node(4);
		root.left.left = n1;
		root.left.right = new Node(5);
		final Node n2 = new Node(8);
		root.left.right.right = n2;
		root.left.right.left = new Node(7);

		final PrintPathRootToNode i = new PrintPathRootToNode();
		path = new ArrayList();
		i.printPath(root, n2);
		Collections.reverse(path);
		System.out.println(" Path " + path);
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(final int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

}


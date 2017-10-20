package com.sree.leave.programs.algorithms;

public class BinaryTreeLCA {
	public static Node lca(Node root, Node node1, Node node2) {
		if (null == root) {
			return root;
		}
		if (root == node1 || root == node2) {
			return root;
		}
		Node left = lca(root.left, node1, node2);
		Node right = lca(root.right, node1, node2);

		if (left != null && right != null) {
			return root;
		}
		if (left != null)
			return left;
		else
			return right;
	}

	public static void main(String[] args) {
		// root level 0
		Node A = Node.createNode(50);
		// Level 1
		Node B = Node.createNode(25);
		Node C = Node.createNode(75);
		// Level 2
		Node D = Node.createNode(15);
		Node E = Node.createNode(40);
		Node F = Node.createNode(60);
		Node G = Node.createNode(95);

		// Level 3
		Node H = Node.createNode(10);
		Node I = Node.createNode(20);
		Node J = Node.createNode(30);
		Node K = Node.createNode(45);
		Node L = Node.createNode(55);
		Node M = Node.createNode(65);

		// connect Level 0 and 1
		A.left = B;
		A.right = C;
		// connect level 1 and level 2
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		// connect level 2 and level 3
		D.left = H;
		D.right = I;
		E.left = J;
		E.right = K;
		F.left = L;
		F.right = M;

		Node lca = BinaryTreeLCA.lca(A, D, H);
		String message = String.format("1. LCA[Node D (%d) & Node H (%d)] = %d", D.data, H.data, lca.data);
		System.out.println(message);

		lca = BinaryTreeLCA.lca(A, I, K);
		message = String.format("2. LCA[Node I (%d) & Node K (%d)] = %d", I.data, K.data, lca.data);
		System.out.println(message);

		lca = BinaryTreeLCA.lca(A, I, M);
		message = String.format("3. LCA[Node I (%d) & Node M (%d)] = %d", I.data, M.data, lca.data);
		System.out.println(message);
	}
	static class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int num) {
			this.data = num;
			this.left = null;
			this.right = null;
		}

		public Node() {
			this.left = null;
			this.right = null;
		}

		public static Node createNode(int number) {
			return new Node(number);
		}
	}
}

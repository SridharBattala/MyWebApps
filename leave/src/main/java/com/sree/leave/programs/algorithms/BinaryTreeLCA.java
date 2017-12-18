package com.sree.leave.programs.algorithms;

/*
 * http://www.makeinjava.com/lca-lowest-least-common-ancestor-binary-tree-recursive-example/
 */
public class BinaryTreeLCA {
	public static Node lca(final Node root, final Node node1, final Node node2, final String side) {
		System.out.println("inputs=" + root + ", " + node1 + "," + node2 + "," + side);

		if (null == root) {
			System.out.println("output=" + root + " ," + 11);
			return root;
		}

		if (root == node1 || root == node2) {
			System.out.println("output=" + root + " ," + 16);
			return root;
		}
		final Node left = lca(root.left, node1, node2, "left");
		// System.out.println("left=" + (left != null ? left.data : null));
		final Node right = lca(root.right, node1, node2, "right");
		// System.out.println("right=" + (right != null ? right.data : null));
		if (left != null && right != null) {
			System.out.println("output=" + root + " ," + 24);
			return root;
		}
		if (left != null) {
			System.out.println("output=" + left + " ," + 28);
			return left;
		} else {
			System.out.println("output=" + right + " ," + 31);
			return right;
		}

	}

	public static void main(final String[] args) {
		// root level 0
		final Node A = Node.createNode(50);
		// Level 1
		final Node B = Node.createNode(25);
		final Node C = Node.createNode(75);
		// Level 2
		final Node D = Node.createNode(15);
		final Node E = Node.createNode(40);
		final Node F = Node.createNode(60);
		final Node G = Node.createNode(95);

		// Level 3
		final Node H = Node.createNode(10);
		final Node I = Node.createNode(20);
		final Node J = Node.createNode(30);
		final Node K = Node.createNode(45);
		final Node L = Node.createNode(55);
		final Node M = Node.createNode(65);

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
		Node lca = null;

		lca = BinaryTreeLCA.lca(A, J, E, "parent");
		System.out.println(String.format("LCA=%s", lca.data));

		// lca = BinaryTreeLCA.lca(A, I, K); message =
		// String.format("2. LCA[Node I (%d) & Node K (%d)] = %d", I.data,
		// K.data, lca.data); System.out.println(message);
		//
		//
		// lca = BinaryTreeLCA.lca(A, I, M);
		// message = String.format("3. LCA[Node I (%d) & Node M (%d)] = %d",
		// I.data, M.data, lca.data);
		// System.out.println(message);
	}
	static class Node {
		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}

		public int data;
		public Node left;
		public Node right;

		public Node(final int num) {
			this.data = num;
			this.left = null;
			this.right = null;
		}

		public Node() {
			this.left = null;
			this.right = null;
		}

		public static Node createNode(final int number) {
			return new Node(number);
		}
	}
}

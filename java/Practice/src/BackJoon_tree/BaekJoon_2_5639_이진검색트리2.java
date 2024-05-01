package BackJoon_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2_5639_이진검색트리2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();
		String data = "";
		while ((data = in.readLine()) != null) {
			int idata = Integer.parseInt(data);
			Node node = new Node(idata);
			tree.insertNode(node, tree.root);
		}
		tree.print();
	}
}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}

class Tree {
	Node root;

	void insertNode(Node node, Node iter) {
		if (root == null) {
			root = node;
			return;
		}

		if (node.data > iter.data) {
			if (iter.right != null)
				insertNode(node, iter.right);
			else
				iter.right = node;
		} else {
			if (iter.left != null)
				insertNode(node, iter.left);
			else
				iter.left = node;
		}
	}

	void print() {
		StringBuilder sb =new StringBuilder();
		printPostOrder(root,sb);
		System.out.println(sb);
	}
	
	void printPostOrder(Node iter, StringBuilder sb) {
		if (iter == null)
			return;

		printPostOrder(iter.left,sb);
		printPostOrder(iter.right,sb);
		sb.append(iter.data).append("\n");
	}
}
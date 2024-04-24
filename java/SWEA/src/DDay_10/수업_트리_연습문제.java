package DDay_10;

import java.util.Scanner;

class Node {
	int num;
	Node left;
	Node right;

	Node() {
	}
}
/*
13 
1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
 */

public class 수업_트리_연습문제 {

	static Node[] nodes = new Node[14]; //노드 타입 배열 
	static int[] count = new int[14];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 1; i < 14; i++) {
			nodes[i] = new Node();
			nodes[i].num = i;
		}

		int V = sc.nextInt();
		// V - 1개 간선의 정보가 주어진다
		for (int i = 0; i < V - 1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();

			count[child]++;

			if (nodes[	].left == null) {
				nodes[parent].left = nodes[child];
			} else {
				nodes[parent].right = nodes[child];
			}
		}

		int root = -1;
		for (int i = 1; i < 14; i++) {
			if (count[i] == 0) {
				root = i;
			}
		}

		preorder(nodes[root]);
	}

	// VLR //전위 순회 
	static void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.num);
		preorder(node.left);
		preorder(node.right);
	}
}

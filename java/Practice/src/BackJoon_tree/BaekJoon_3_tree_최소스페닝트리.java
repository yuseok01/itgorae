package BackJoon_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon_3_tree_최소스페닝트리 {
	public static ArrayList<Node> edgeList;
	public static int[] p;
	private static int v, e;

	static class Node implements Comparable<Node> {

		int from;
		int to;
		int w;

		public Node(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		p = new int[v + 1];
		edgeList = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edgeList.add(new Node(a, b, c));
		}
		// step1 정렬
		Collections.sort(edgeList);
		
		// step2
		make();
		int sum = 0; // 결과를 위함
		int count = 0;// 종료를 위함
		for (Node node : edgeList) {
			if (union(node.from, node.to)) {
				sum += node.w;
				if (++count == v - 1)
					break; // 종료조건 노선 -1
			}
		}
		System.out.println(sum);
	}

	private static int find(int a) {
		if (a == p[a])
			return a;
		return p[a] = find(p[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		p[bRoot] = aRoot;
		return true;
	}

	private static void make() {
		for (int i = 0; i < v; i++) {
			p[i] = i;
		}
	}
}
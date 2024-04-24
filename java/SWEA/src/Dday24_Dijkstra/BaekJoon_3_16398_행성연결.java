package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 배열로 주어질때 간선갯수가 주어지지않음  
 * arrayList로 new Node 추가 
 */
public class BaekJoon_3_16398_행성연결 {
	static ArrayList<Node> edgeList = new ArrayList<>();
	static int n;
	static int[] parents;
	static long ans;

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
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		parents = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp!=0) {
				edgeList.add(new Node(i, j, tmp));
				}
			}
		}
		Collections.sort(edgeList);

		make();

		int cnt = 0;
		
		for (Node node : edgeList) {
			if (union(node.from, node.to)) {
				ans += node.w;
				cnt++;
				
				if (cnt == n - 1)
					break;
			}
		}
		System.out.println(ans);

	}

	private static boolean union(int from, int to) {
		int aRoot = find(from);
		int bRoot = find(to);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		else {
			return parents[a] = find(parents[a]);
		}

	}

	private static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

	}
}

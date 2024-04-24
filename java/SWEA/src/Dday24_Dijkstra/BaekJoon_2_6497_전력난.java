package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 간선으로 주어질때 2 4 6
 * 인접 행렬 
 * 
 */
public class BaekJoon_2_6497_전력난 {
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

	private static int V;
	private static int E;
	private static int[] parents;
	private static Node[] edgeList;
	private static int totalW;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (V == 0 && E == 0) {
				break;
			}
			parents = new int[V];
			edgeList = new Node[E];
			totalW = 0;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				totalW += weight;
				edgeList[i] = new Node(from, to, weight);

			}

			// step1 자기자신을 부모로 make();
			make();

			Arrays.sort(edgeList); // 가중치 기준으로 정렬
			int result = 0;

			for (int i = 0; i < edgeList.length; i++) { // edgeList의 길이가 뜻하는바
				Node edge = edgeList[i];
				// 부모 같은지 확인 find
				if (find(edge.from) != find(edge.to)) {// 부모가 다르다면 가중치는 저장하고 부모를 합처야겠지?
					result += edge.w;
					union(edge.from, edge.to);
				}
			}
			System.out.println(totalW - result);
		}
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parents[b] = a;
		}

	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}

	}

}

package BackJoon_tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_4_1647_도시분할계획 {
	static Node[] edgeList;
	static int[] parents;
	static int V, E;

	static class Node implements Comparable<Node> {
		int from;
		int to;
		int w;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.w = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V + 1];
		edgeList = new Node[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgeList[i] = new Node(from, to, w); // i배열에 각 간선 저장

		}
		// step 1 make
		make();

		Arrays.sort(edgeList);// 가중치 기준으로 정렬
		int result = 0;
		int count = 0;
		for (int i = 0; i < edgeList.length; i++) {
			Node edge = edgeList[i];

			if (find(edge.from) != find(edge.to)) { // 갈려는곳의 부모가 같지않다면
				result += edge.w;
				union(edge.from, edge.to);

				count = edge.w;

			}
		}
		System.out.println(result - count);
	}

	private static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i; // 자기자신이 부모
		}

	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parents[y] = x; // y의 부모에 합친다.
		}
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);

	}

}

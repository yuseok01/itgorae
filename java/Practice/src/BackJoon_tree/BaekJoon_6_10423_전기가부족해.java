package BackJoon_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//7 9 2
//6 7
//1 2 1
//2 3 1
//3 4 1
//4 5 1
//4 6 10
//5 7 10
//1 4 1
//2 5 1
//3 5 1

//14
public class BaekJoon_6_10423_전기가부족해 {
	/*
	 * make + 발전소는 -1 + find(발전소는 -1, 그냥 노드면 부모 반환) + union (발전소에 붙이기)
	 */
	private static int v;
	private static int e;
	private static int powerNum;
	private static ArrayList<Node> edgeList = new ArrayList<>();
	private static int[] parents;
	private static int ans;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		powerNum = Integer.parseInt(st.nextToken());
		parents = new int[v + 1];

		make();
		// 자신의 부모가르키도록

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= powerNum; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			parents[tmp] = -1;
		}
		// 발전소 부모는 -1

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList.add(new Node(from, to, w));
		}

		Collections.sort(edgeList);

		for (int i = 0; i < e; i++) { //e까지 돌게 하면서 조건에 해당하는것만 ans에 올리기 
			Node now = edgeList.get(i);
			if (find(now.from) != find(now.to)) {
				/*
				 * 나가는 곳과 갈곳의 부모가 다르면 == 발전소끼리 연결 x , 이미 연결된 곳 끼리 연결 x
				 */
				union(now.from, now.to);
				// 부모 합치기
				ans += now.w;
				// 가중치 누적

			}
		}
		System.out.println(ans);

	}

	private static void make() {
		for (int i = 1; i <= v; i++) {
			parents[i] = i;
		}
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {

			if (aRoot == -1)
				parents[bRoot] = aRoot;
			// a가 발전소면 a에 b 붙이기
			else if (bRoot == -1)
				parents[aRoot] = bRoot;
			// b가 발전소면 b에 a 붙이기
			else {
				if (aRoot > bRoot)
					parents[aRoot] = bRoot;
				else
					parents[bRoot] = aRoot;
				// 암것도아니면 그냥 큰쪽에 붙이기
			}

		}

	}

	private static int find(int a) {
		if (parents[a] == -1)
			return -1; // a가 발전소면 -1
		if (a == parents[a])
			return a; // 부모 찾으면 부모 리턴
		else
			return find(parents[a]); // 아니면 부모 찾을때까지 재귀
	}
}

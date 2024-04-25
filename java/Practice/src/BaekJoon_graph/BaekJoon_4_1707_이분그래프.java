package BaekJoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 *이분그래프는 이웃하는 노드들이 같은 집합에 속하지 않는 것
 *
 */
public class BaekJoon_4_1707_이분그래프 {
	static List<Integer>[] list;
	private static int V;
	private static int E;
	static int[] visited;
 //true false 0 1 2
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			visited = new int[V + 1];
			for (int i = 0; i <= V; i++) {
				list[i] = new ArrayList<>();
				visited[i] = 0;
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}

			find();

		}
	}

	static void find() {

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= V; i++) {
			if (visited[i] == 0) {
				q.add(i);
				visited[i] = 1; // 1번색 123 45
			}
			while (!q.isEmpty()) {
				int now = q.poll();

				for (int j = 0; j < list[now].size(); j++) {
					if (visited[list[now].get(j)] == 0) { // 방문 안했으면
						q.add(list[now].get(j)); // 자식을 넣는다.
					}
					if (visited[list[now].get(j)] == visited[now]) {
						System.out.println("NO");
						return;
					}
					if (visited[now] == 1 && visited[list[now].get(j)] == 0) {

						visited[list[now].get(j)] = 2;
					} else if (visited[now] == 2 && visited[list[now].get(j)] == 0) {
						visited[list[now].get(j)] = 1;

					}
				}
			}
			
		}
		System.out.println("YES");

	}
}

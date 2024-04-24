/*
 * (0,0) -> m1 -> (n,n)
 * 			vs
 * (0,0) -> m2 -> (n,n)
 * 다익스트라 
 * 
 */
package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test2_서울_5반_김유석 {
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int w;

		public Node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Test2_서울_5반_김유석.Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int[][] minDanger;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int INF;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());// 마을 크기
			m = Integer.parseInt(st.nextToken()); // 쉼터 갯수

			minDanger = new int[n][n];
			map = new int[n][n];
			INF = Integer.MAX_VALUE;
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					minDanger[i][j] = INF;
				}
			}
			int result = Integer.MAX_VALUE; // 각 경유지 최소값 저장 할 변수
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				// (0,0) -> m
				int aResult = Goal(0, 0, a, b);

				// m -> (n,n)
				int bResult = Goal(a, b, n-1 , n-1 )-map[a][b];

				// 합
				result = Math.min(result, aResult + bResult);
				// 최소값

			}
			System.out.println("#" + t + " " + result);
		}
	}

	static int Goal(int startX, int startY, int finishX, int finishY) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[n][n]; // 메서드 진입할때마다 방문, 최소 비용 배열 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				minDanger[i][j] = INF;
			}
		}
		minDanger[startX][startY] = map[startX][startY];
		pq.add(new Node(startX, startY, minDanger[startX][startY]));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visited[now.x][now.y]) {
				visited[now.x][now.y] = true;
			}
			for (int k = 0; k < 4; k++) {
				int idx = now.x + dx[k];
				int idy = now.y + dy[k];
				if (0 <= idx && idx < n && 0 <= idy && idy < n && !visited[idx][idy]) {
					if (minDanger[idx][idy] > minDanger[now.x][now.y] + map[idx][idy]) {
						minDanger[idx][idy] = minDanger[now.x][now.y] + map[idx][idy];
						visited[idx][idy] = true;
						pq.add(new Node(idx, idy, minDanger[idx][idy]));
					}
				}
			}
		}
		return minDanger[finishX][finishY];
	}
}

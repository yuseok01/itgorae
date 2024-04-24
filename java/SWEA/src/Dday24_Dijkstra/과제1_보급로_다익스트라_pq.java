package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 배열로 다익스트라 
 * 시작점과 끝점이 주어진다. 
 * 저장할 배열이필요하다 최소를 갱신 2차원배열 
 * 
 */
public class 과제1_보급로_다익스트라_pq {

	static int N;
	static int INF = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] minDistance;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int w;

		Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
			// w기준으로 정렬 규칙
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			minDistance = new int[N][N];

			for (int[] arr : minDistance) {
				Arrays.fill(arr, INF);
			} // distance max값으로 초기화

			for (int x = 0; x < N; x++) {
				// 배열 입력
				String[] Str = br.readLine().split("");
				// 한줄 읽고
				for (int y = 0; y < N; y++) {
					map[x][y] = Integer.parseInt(Str[y]);
					// char를 숫자열로 변경
				}
			}
			dijkstra(0, 0);

			System.out.println("#" + t + " " + minDistance[N - 1][N - 1]);
			// 목적지가 N-1 N-1이니깐
		}
	}

	private static void dijkstra(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];

		minDistance[x][y] = 0;

		pq.add(new Node(x, y, 0)); // 시작 위치 가중치는 0

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visited[now.x][now.y]) {
				visited[now.x][now.y] = true;
			}
			for (int k = 0; k < 4; k++) {
				int idx = now.x + dx[k];
				int idy = now.y + dy[k];
				if (0 <= idx && idx < N && 0 <= idy && idy < N && !visited[idx][idy]) {
					if (minDistance[idx][idy] > minDistance[now.x][now.y] + map[idx][idy]) {
						minDistance[idx][idy] = minDistance[now.x][now.y] + map[idx][idy];
						visited[idx][idy] = true;
						pq.add(new Node(idx, idy, minDistance[idx][idy]));

					}
				}

			}

		}
	}
}

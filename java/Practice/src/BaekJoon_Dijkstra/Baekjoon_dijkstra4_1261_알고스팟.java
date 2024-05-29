package BaekJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_dijkstra4_1261_알고스팟 {
	static class point implements Comparable<point> {
		int x;
		int y;
		int w;

		public point(int x, int y, int w) {

			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(point o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}

	static int[][] map;
	static int n;
	static int m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dist = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]); //맵 배열
				dist[i][j] = Integer.MAX_VALUE; // 가중치 배열 
			}
		}

		dijkstra();
		
		System.out.println(dist[n-1][m-1]);
	}

	private static void dijkstra() {
		PriorityQueue<point> pq = new PriorityQueue<>();
		dist[0][0] = 0; //시작 가중치는 0
		pq.offer(new point(0, 0, 0)); //0,0 에서 가중치 0으로 시작 
		while (!pq.isEmpty()) {
			point now = pq.poll(); // 현재 x ,y 좌표

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				int nextW = now.w;
				if (0 <= nextX && nextX < m && 0 <= nextY && nextY <  ) {
					if(map[nextY][nextX] == 1) {//벽이라면
						nextW++; //가중치 올려주기 
					}
					if(dist[nextY][nextX] > nextW) { //다음 가중치를 작은 값으로 초기화 
						dist[nextY][nextX] = nextW;
						pq.offer(new point(nextX,nextY,nextW)); //큐에 또 넣는거지 
					}
				}
			}
		}

	}

}

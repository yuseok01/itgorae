package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeakJoon_14940_BFS_쉬운최단거리 {
	static int n;
	static int m;
	static int[][] arr;
	static int tmpI;
	static int tmpJ;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[n][m];
		distance = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					tmpI = i;
					tmpJ = j;
				}
			}
		}
		bfs(tmpI, tmpJ); //시작점 위치 가지고 출발
		
		for(int i =0; i< n; i++) {
			for(int j =0; j<m ; j++)
				if(!visited[i][j]&& arr[i][j]==1)
					System.out.print(-1+" ");
				else
					System.out.print(distance[i][j]+" ");
			System.out.println();
		}
	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>(); // 투 포인트 객체 // 시작점 투입
		q.add(new Point(x, y)); // x,y 객체 생성
		visited[x][y] = true;

		while (!q.isEmpty()) { // 큐빌때까지 
			Point current = q.poll(); // 현재 위치에 저장

			for (int i = 0; i < 4; i++) {
				int idx = current.x + dx[i];
				int idy = current.y + dy[i];

				if(0 > idx || idx >= n || m <= idy || idy < 0)
					continue; // 범위 넘어가면 다음 i
				if(arr[idx][idy] == 0)
					continue; // 벽이면 다음 i
				if(visited[idx][idy])
					continue; // 방문 했으면 다음 i
				q.add(new Point(idx, idy)); // 새로운 객체
				distance[idx][idy] = distance[current.x][current.y] + 1; // 깊이가 크기임 
				visited[idx][idy] = true;

			}
		}
	}
}

class Point {
	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

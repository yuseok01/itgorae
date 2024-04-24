package BeakJoon_BFS넓이_BFS깊이;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeackJoon_1_14502_연구소 {
	static int[][] map;
	static boolean[][] check;
	static int n;
	static int m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int result;
	static int wallCnt;
	static int v;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		wallCnt = 0;
		check = new boolean[n][m];
		result = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					wallCnt++;
				}
				if (map[i][j] == 2) {
					v++;
				}
			}
		}
		WallCombination(0); // 벽새울수 있는 모든 조합
		System.out.println(result);
	}

	static void WallCombination(int wall) {
		if (wall == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1; // 하나 써볼께 ~
					WallCombination(wall + 1);
					map[i][j] = 0; // 다썼어~
				}
			}
		}
	}

	static void bfs() {
		int cnt = v;
		check = new boolean[n][m];
		int[][] newMap = new int[n][m];
		for (int i = 0; i < n; i++) { // 복사 배열
			for (int j = 0; j < m; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (newMap[i][j] == 2) {
					q.add(new Point(i, j));
					check[i][j] = true;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				while (!q.isEmpty()) {
					Point current = q.poll();
					for (int k = 0; k < 4; k++) {
						int idx = current.x + dx[k];
						int idy = current.y + dy[k];
						if (0 <= idx && idx < n && 0 <= idy && idy < m && !check[idx][idy] && newMap[idx][idy] == 0) {
							q.add(new Point(idx, idy));
							check[idx][idy] = true;
							cnt++;
							newMap[idx][idy] = 2;
						}
					}
				}
				if (result < (n * m) - (cnt + wallCnt + 3)) {
					result = (n * m) - (cnt + wallCnt + 3);
				}

			}
		}
	}
}

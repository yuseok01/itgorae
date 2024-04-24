package DDay21_DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과제1_GraphSearch_240326 {
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE; // 0넣어도됨 음수는 없늬깐
		int cnt;
		cheese = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int day = 0; day <= 100; day++) { // 100일
			cnt = 0;
			visited = new boolean[N][N];
			eat(cheese, day);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == false && cheese[i][j] != 0) {
						cnt++;
						count(i, j);
					}
				}
			}

			if (max < cnt)
				max = cnt;
		}
		System.out.println( max);

	}

	public static void eat(int[][] cheese, int day) {
		for (int i = 0; i < cheese.length; i++) {
			for (int j = 0; j < cheese.length; j++) {
				if (cheese[i][j] == day) {
					cheese[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}
	}

	public static void count(int X, int Y) {
		int oX = X;
		int oY = Y;
		int idx;
		int idy;

		visited[oX][oY] = true;

		for (int i = 0; i < 4; i++) {
			idx = oX + dx[i];
			idy = oY + dy[i];

			if (idx >= 0 && idx < cheese.length && idy < cheese.length && idy >= 0 && !visited[idx][idy]
					&& cheese[idx][idy] != 0)

				count(idx, idy);
		}
	}
}
package im대비;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day2_2_나이트의이동 {
	static int[][] map;
	static boolean[][] check;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int cnt;
	static int n;
	private static LinkedList<Integer> result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {// testCase
			result = new LinkedList<Integer>();
			n = sc.nextInt();
			map = new int[n][n];
			check = new boolean[n][n];
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[sc.nextInt()][sc.nextInt()] = 2;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 1 && map[i][j] != 2) {
						map[i][j] = 0;
					}
				}
			}
			cnt = 0;
			dfs(a, b);
			int min = Collections.min(result);
			System.out.println(min);
		}

	}

	static void dfs(int i, int j) {
		check[i][j] = true;

		if (map[i][j] == 2) {
			cnt++;
			result.add(cnt);
			cnt=0;
			return;
		}

		for (int k = 0; k < 8; k++) {
			int idx = i + dx[k];
			int idy = j + dy[k];
			if ( 0 <= idx && idx < n && 0 <= idy && idy < n && !check[idx][idy]) {
				dfs(idx, idy);
				cnt++;
			}
		}
	}

}

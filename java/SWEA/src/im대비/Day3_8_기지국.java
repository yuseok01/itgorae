package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_8_기지국 {
	static boolean[][] visited;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int length = Integer.parseInt(br.readLine());
			map = new char[length][length];
			visited = new boolean[length][length];
			for (int i = 0; i < length; i++) {
				String temp = br.readLine();
				for (int j = 0; j < length; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {

					if (map[i][j] == 'A') {
						visited[i][j] = true;
						for (int k = 0; k < 4; k++) {
							int idx = i + dx[k];
							int idy = j + dy[k];
							if (0 <= idx && idx < length && 0 <= idy && idy < length) {
								visited[idx][idy] = true;
							}
						}
					} else if (map[i][j] == 'B') {
						visited[i][j] = true;
						for (int k = 0; k < 4; k++) {
							for (int l = 1; l <= 2; l++) {
								int idx = i + l * dx[k];
								int idy = j + l * dy[k];
								if (0 <= idx && idx < length && 0 <= idy && idy < length) {
									visited[idx][idy] = true;
								}

							}
						}
					} else if (map[i][j] == 'C') {
						visited[i][j] = true;
						for (int k = 0; k < 4; k++) {
							for (int l = 1; l <= 3; l++) {
								int idx = i + l * dx[k];
								int idy = j + l * dy[k];
								if (0 <= idx && idx < length && 0 <= idy && idy < length) {
									visited[idx][idy] = true;
								}

							}
						}
					}

				}
			}
			int cnt = 0;
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (!visited[i][j] && map[i][j] == 'H') {
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}

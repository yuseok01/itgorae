package DDay_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연습_창용마을 {
	static int arr[][];
	static boolean check[];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			
			arr = new int[N][N];
			check = new boolean[N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a - 1][b - 1] = 1;
				arr[b - 1][a - 1] = 1;

			}
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				if (!check[i]) {
					dfs(i);
					for (int j = 0; j < N; j++) {
						if (!check[j]) {// 한바퀴 돌았는데 false가 있으면 ++
						cnt++;
						break; // cnt만 올리고 가까운 j for문 종료 
						}

					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}

	}

	public static void dfs(int k) {
		if (!check[k]) {
			check[k] = true;
			for (int i = 0; i < N; i++) {
				if (arr[k][i] == 1 && !check[i]) {
					dfs(i);
				}
			}
		}
	}
}

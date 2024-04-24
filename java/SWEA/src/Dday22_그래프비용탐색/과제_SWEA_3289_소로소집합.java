package Dday22_그래프비용탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과제_SWEA_3289_소로소집합 {
	static int n; // 원소의 개수
	static int[] parents; // 부모 원소를 관리

	private static void make_set() { // 유일한 맴버 x를 포함하는 새로운 집합을 생성하는 연산 최초 한번만 실행
		for (int i = 0; i < n + 1; i++) { //
			parents[i] = i; //p[x] <- x
		}
	}
	private static int find_set(int x) { // x에 대가리 나와
		if (x != parents[x]) { 
			parents[x]=find_set(parents[x]);
		}
			return parents[x];
	}

	private static boolean union(int x, int y) { //두 집합 합치려면 x의 루트와 y의 루트가 같은지 먼저확인 같지않으면 합치기
		int xRoot = find_set(x);
		int yRoot = find_set(y);
		if (xRoot == yRoot)
			return false;

		parents[yRoot] = xRoot; // x루트를 y루트에 연결 후 트루 반환
		return true;
	}

	/*
	 * tc n이하자연수 m행갯수 0찾기 집합1 집합2 1합치기
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parents = new int[n + 1];
			make_set();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int k = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (k == 0) {
					union(a, b);
				} else if (k == 1) {
					if (find_set(a) == find_set(b)) {
						sb.append(1);
					} else
						sb.append(0);
				}
			}
			 sb.append("\n");

		}
		System.out.println(sb);

		br.close();
	}
}

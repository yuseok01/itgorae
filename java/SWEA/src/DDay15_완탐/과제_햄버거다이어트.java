package DDay15_완탐;

import java.util.Scanner;

public class 과제_햄버거다이어트 {
	static int n; // 재료수
	static int l; // 제한 칼로리
	static int[][] arr; // 재료
	static boolean[] check; // 체크
	static int favorite;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) { // 테케
			n = sc.nextInt(); // 재료 수 입력
			l = sc.nextInt(); // 칼로리  입력 
			arr = new int[n][2]; // n행 2열; 
			check = new boolean[n]; //n행 만큼만 방문 체크 보면됨 
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {

					arr[i][j] = sc.nextInt();
				}
			}
			favorite = 0; //테케마다 초기화 
			dfs(0);
			System.out.println("#"+tc+" "+favorite);
		}
	}
	static void dfs(int idx) {
		if (idx >= n) {
			int temp = 0;
			int maxIdx = 0;
			for (int i = 0; i < n; i++) {
				if (check[i]) {
					temp += arr[i][1];
						maxIdx += arr[i][0];
					}
			}
			if (temp <= l) {
				if (favorite <= maxIdx) {
					favorite = maxIdx;
				}
			}
			return;
		}
		check[idx] = true;
		dfs(idx + 1);
		check[idx] = false;
		dfs(idx + 1);
	}
}

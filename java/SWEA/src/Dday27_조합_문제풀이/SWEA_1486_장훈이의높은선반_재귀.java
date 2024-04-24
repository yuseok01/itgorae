package Dday27_조합_문제풀이;
import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반_재귀 {
	static int N, B, ans; // N: 점원의 수 1~20, B : 선반의 높이
	static int[] H; // 점원들의 키 배열 1~10000
	static boolean[] sel; // 해당 점원 썼는지 쳌

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];// 총 N명의 점원이 존재한다.
			sel = new boolean[N];
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			} // 입력 끝
			
			powerset(0);
			
			System.out.println("#" + tc + " " + (ans - B));
		} // tc
	}// main

	// idx : 지금 선택할지 말지 결정할 직원
	public static void powerset(int idx) {
		// 기저조건
		if (idx == N) { // 이제 모든 직원 다 고려했어!
			int sum = 0; // 이번에 만들어진 탑의 높이
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += H[i];
				}
			} // 탑의 높이를 다 구했다!

			if (sum >= B)
				ans = Math.min(ans, sum); // 위험하니까 넘었으면 작은 값!
			return;
		}

		// 재귀조건
		sel[idx] = true; // 해당 직원 쌓아
		powerset(idx + 1);

		sel[idx] = false; // 해당 직원 나가있어!
		powerset(idx + 1);

	}

}

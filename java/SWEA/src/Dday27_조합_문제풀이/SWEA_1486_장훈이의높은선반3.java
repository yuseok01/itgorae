package Dday27_조합_문제풀이;
import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반3 {
	static int N, B, ans; // N: 점원의 수 1~20, B : 선반의 높이
	static int[] H; // 점원들의 키 배열 1~10000

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];// 총 N명의 점원이 존재한다.
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			} // 입력 끝

			powerset(0, 0);

			System.out.println("#" + tc + " " + (ans - B));
		} // tc
	}// main

	// idx : 지금 선택할지 말지 결정할 직원
	// sum : 내가 지금까지 쌓아온 탑의 높이!
	public static void powerset(int idx, int sum) {
		//내가 현재 가지고 있는 최고의 값 ans를 
		//이미 벗어난 sum? 그 탑? 필요없어!
		if(sum > ans) return; 
		// 기저조건
		if (idx == N) { // 이제 모든 직원 다 고려했어!
			if (sum >= B)
				ans = Math.min(ans, sum);
			return;
		}
		// 재귀조건
		powerset(idx + 1, sum + H[idx]); // 쌓고 가고
		powerset(idx + 1, sum); // 안쌓고 가고
	}
}













package Dday27_조합_문제풀이;
import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반4 {
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

			int rs = 0; // 모든 점원들의 키 합
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
				rs += H[i];
			} // 입력 끝

			powerset(0, 0, rs);

			System.out.println("#" + tc + " " + (ans - B));
		} // tc
	}// main

	// idx : 지금 선택할지 말지 결정할 직원
	// sum : 내가 지금까지 쌓아온 탑의 높이!
	// rsum : 앞으로 내가 쌓을 수 있는 탑의 높이!
	public static void powerset(int idx, int sum, int rsum) {
		// 내가 현재 가지고 있는 최고의 값 ans를
		// 이미 벗어난 sum? 그 탑? 필요없어!
		if (sum > ans)
			return;
		// 지금 내가 가지고 있는 탑의 높이와 앞으로 쌓을 수 있는 탑의 높이의 합이
		// B : 선반의 높이가 안되면 애초에 그건 답이 될 수 없어!
		if (sum + rsum < B) // 내가 가지고 있는 sum과 남은 rsum을 합처도 b가 안된다
			return;

		// 기저조건
		if (idx == N) { // 이제 모든 직원 다 고려했어!
			if (sum >= B)
				ans = Math.min(ans, sum);
			return;
		}
		
		// 재귀조건
		powerset(idx + 1, sum + H[idx], rsum - H[idx]); // 쌓고 가고
		powerset(idx + 1, sum, rsum - H[idx]); // 안쌓고 가고
	}
}

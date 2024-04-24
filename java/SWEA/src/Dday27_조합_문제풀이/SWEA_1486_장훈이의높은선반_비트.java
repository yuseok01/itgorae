package Dday27_조합_문제풀이;
import java.util.Scanner;

public class SWEA_1486_장훈이의높은선반_비트 {
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

			// 비트마스킹
			for (int i = 1; i < 1 << N; i++) { // 1. i는 모든 부분집합이다.
				int sum = 0; // i 탑의 높이
				for (int j = 0; j < N; j++) {// 2. i라고 하는 탑에 누구누구를 쌓았는지를 쳌
					if ((i & (1 << j)) > 0) { // 3. j번째 직원은 탑에 소속되어 있다.
						sum += H[j];
					}
				} // i번째 탑의 높이 다구했어!!!

				if (sum >= B && sum < ans) {
					ans = sum;
				}

//				if(sum >= B) {
//					ans = Math.min(ans, sum);
//					ans = sum < ans ? sum : ans;
//				}
			} // 모든 부분집합 비교 완료오

			System.out.println("#" + tc + " " + (ans - B));
		} // tc
	}// main
}

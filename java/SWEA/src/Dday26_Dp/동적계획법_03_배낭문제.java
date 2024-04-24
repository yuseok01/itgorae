import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법_03_배낭문제 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		int N = sc.nextInt(); // 물건의 개수
		int W = sc.nextInt(); // 배낭의 무게

		int[] weights = new int[N + 1];
		int[] cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			cost[i] = sc.nextInt();
		} // 입력완

		int[][] dp = new int[N + 1][W + 1]; // i번까지의 물건을 고려할고 w무게만큼만
		// 물건은 한개씩만 존재한다.
		for (int i = 1; i <= N; i++) {
			// 1~i번까지 물건을 고려하겠다.
			// 임시 무게 w
			for (int w = 0; w <= W; w++) {
				// 내가 고려해야될 i번째의 물건의 무게가, 임시무게 보다 적다면
				// 이 물건 넣을지 말지 고민 해야 됨.
				if (weights[i] <= w) {
					// 현재 w 무게에서의 최적해 dp[i-1][w]
					// 이번 물건 i를 고려한다면 최적해 dp[i-1][w-weigths[i]+cost[i]
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + cost[i]);

				} else {
					// 현재 가방에 넣을 수 없다면 이전 물건까지 고려한 값을 가져와
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		System.out.println(dp[N][W]);

	}

	static String input = "4 10\r\n" + "5 10\r\n" + "4 40\r\n" + "6 30\r\n" + "3 50\r\n" + "";
}

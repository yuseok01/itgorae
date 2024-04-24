package Dday26_Dp;

import java.util.Arrays;
import java.util.Scanner;

public class 동적계획법_02_동전거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt(); // 해당 거스름돈의 최소 동전 개수를 구하고 싶다.
		// 사용할 수 있는 동전 : 1원 / 4원 / 6원

		int[] dp = new int[money + 1]; // 해당 money 구하고 싶다!
		// dp[0] = 0; //0원은 줄수 없다.

		for (int i = 1; i <= money; i++) {
			int minCnt = 987654321; //i원에 대한 최소 거스름돈 개수
			//1원을 작은 부분문제에 추가하겠다.
			minCnt = Math.min(minCnt, dp[i-1]+1);
			if(i>=4)
				minCnt = Math.min(minCnt, dp[i-4]+1);
			if(i>=6)
				minCnt = Math.min(minCnt, dp[i-6]+1);
			// 고려할 동전 다 고려했어.
			dp[i] = minCnt;
		}
		
		System.out.println(Arrays.toString(dp));
	}
}

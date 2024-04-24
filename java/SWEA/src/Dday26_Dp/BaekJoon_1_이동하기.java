package Dday26_Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 2차원 배열의 dp
 * 항상 더미를 포함한다. 
 */
public class BaekJoon_1_이동하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[n+1][m+1];
		int [][] dp = new int[n+1][m+1];
		
		map[0][0] = 0;
		dp[0][0] = 0;
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i <= n ; i++) {
			for(int j = 1 ; j <= m ; j++) {
				dp[i][j] = Math.max(map[i][j]+dp[i-1][j], map[i][j]+dp[i][j-1]);
			}
		}
		System.out.println(dp[n][m]);
	}
}

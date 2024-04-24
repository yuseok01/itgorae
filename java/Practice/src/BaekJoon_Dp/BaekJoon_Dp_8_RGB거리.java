package BaekJoon_Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_Dp_8_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] cost = new int[n][3];
		int [][] dp = new int[n][3];
		
		for(int i = 0 ; i < n ; i++) {
			st= new StringTokenizer(br.readLine());
			cost[i][0] =  Integer.parseInt(st.nextToken()); //red
			cost[i][1] = Integer.parseInt(st.nextToken()); //green
			cost[i][2] = Integer.parseInt(st.nextToken()); //blue
		}
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for(int i = 1; i < n ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				if(j==0) {
					dp[i][j] += cost[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
				}
				else if (j==1) {
					dp[i][j] += cost[i][1]+ Math.min(dp[i-1][0],dp[i-1][2]);
				}
				else if (j==2) {
					dp[i][j] += cost[i][2] +Math.min(dp[i-1][0], dp[i-1][1]);
				}
			}
		}
		System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
		
	}
}

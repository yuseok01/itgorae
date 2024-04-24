package BaekJoon_Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_Dp_3동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int N = Integer.parseInt(br.readLine());
        int mod = 9901;
        int [][]dp = new int[N+1][3]; // 아무것도 안넣을때 0 왼쪽 1 오른쪽 2
         //각 배열에 누적합 초기화 할것임
        //기저조건 
        dp[1][0]=dp[1][1]=dp[1][2]=1;
        
        for(int i = 2; i<=N ; i++) { //두번째줄 부터 맨끝까지
        	dp[i][0]= (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])% mod;
        	dp[i][1]= (dp[i-1][0] + dp[i-1][2])% mod;
        	dp[i][2] = (dp[i-1][0] + dp[i-1][1])%mod;
        }
        System.out.println((dp[N][0]+dp[N][1]+dp[N][2]) % mod);
    }

}
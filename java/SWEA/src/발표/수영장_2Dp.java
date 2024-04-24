package 발표;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 수영장_2Dp {
   public static int T, minPrice;
   public static int[] prices = new int[4];
   public static int[] dp = new int[13];
 
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
 
      T = Integer.parseInt(br.readLine());
 
      for (int tc = 1; tc <= T; tc++) {
         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < 4; i++) {
            prices[i] = Integer.parseInt(st.nextToken()); //가격 배열 1일 1달 3달 1년
         }
 
         st = new StringTokenizer(br.readLine());
         for (int i = 1; i <= 12; i++) {
            int count = Integer.parseInt(st.nextToken()); //12개의 이용 계획 
             
            dp[i] = Math.min(dp[i - 1] + prices[1], dp[i - 1] + prices[0] * count);
             
            if (i >= 3) {
               dp[i] = Math.min(dp[i], dp[i - 3] + prices[2]);
            }
         }
         
         if(dp[12] > prices[3]) {
            dp[12] = prices[3];
         }
         System.out.println("#" + tc + " " + dp[12]);
      }
   }
}
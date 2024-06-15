import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_6_2302_극장좌석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int n = Integer.parseInt(br.readLine());
		int vipN = Integer.parseInt(br.readLine());
		
		int [] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2 ; i <= n ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		int result = 1;
		int beforeArea = 0;
		int vipSeat = 0;
		for(int i = 0 ; i  < vipN ; i++) {
			vipSeat = Integer.parseInt(br.readLine());
			result *= dp[vipSeat-1 - beforeArea];
			beforeArea= vipSeat;
		}
		result *= dp[n - beforeArea];
		System.out.println(result);
	}

}

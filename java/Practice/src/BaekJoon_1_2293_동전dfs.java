import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1_2293_동전dfs {
	private static int n;
	private static int k;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int [] coins = new int[n];
		for(int i = 0 ;i < n;i++) {
			st = new StringTokenizer(br.readLine());
			coins[i] = Integer.parseInt(st.nextToken());	
		}
		int [] dp = new int[k+1];
		dp[0] =1;
		for(int coin : coins) { 
			for(int j = coin ; j<= k;j++) {
				dp[j] += dp[j-coin]; // dp[x] = dp[x] + dp[0]...
			}
		}
		System.out.println(dp[k]);
				
	}
}

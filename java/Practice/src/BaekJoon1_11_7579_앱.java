import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_11_7579_앱 {

	private static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		//실행중인 앱갯수 1< n <100
		
		 m = Integer.parseInt(st.nextToken());
		//실행중인 앱의 비용 1< m < 10,000,000
		
		int [] memory = new int[n]; //n번째 앱의 메모리 크기
		int [] cost = new int[n]; //n번째 앱의 메모리 종료 비용
		st = new StringTokenizer(br.readLine());
		for( int i = 0 ; i< n ;i++) {
			memory[i] = Integer.parseInt(st.nextToken());
			
		}
		st = new StringTokenizer(br.readLine());
		for(int j = 0 ; j < n; j++) {
			cost[j] = Integer.parseInt(st.nextToken());
		}
		
		int maxCost = 100*n; // 100(최대비용) * n개의 앱 
		int[]dp = new int[maxCost+1];
		
		for(int i = 0 ; i <= maxCost; i++) {
			dp[i]=0;
		}
		
		for(int i = 0 ; i< n ;i++) {
			int nowMemory = memory[i];
			int nowCost = cost[i];
			
			for(int j = maxCost; j>= nowCost; j--) { // [500-3]+ 30  
				dp[j]= Math.max(dp[j], dp[j-nowCost] + nowMemory);
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i = 0 ;i <= maxCost; i++) {
			if(dp[i] >= m) {
				result = Math.min(result, i);
			}
		}
		System.out.println(result);
		
		
	}
}

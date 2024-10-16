import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_3_18427_함께블록쌓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //학생수
		int m = Integer.parseInt(st.nextToken()); //최대 블록수
		int h = Integer.parseInt(st.nextToken()); //목표 높이 
		int [][] dp = new int[n+1][h+1] ; //[사람수][목표높이]
		
		List<Integer>[] list = new ArrayList[n+1]; //[1번째사람] ...m개 블록
		
		for(int i = 1 ; i < n+1 ; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = new ArrayList<>(); //사용을 위한 초기화 
			while(st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i = 0 ; i <= n ; i++ ) {
			dp[i][0]=1; //0개쌓는 경우도 하나의 경우의 수 
		}
		
		for(int i = 1 ; i <= n ; i++) { //사람수
			for(int j = 1; j <= h ; j++) {//목표높이
				for(int k = 0 ; k < list[i].size() ; k++) {
					if(j - list[i].get(k) < 0) //경계 설정 . 목표 높이보다 가진 블록이 더크면 pass
						continue;
					
					dp[i][j] += dp[i-1][j-list[i].get(k)];
				//i번째 학생이 사용한 블럭
				}
				//+
				//현재 사람 -1 의 경우의수
				dp[i][j] += dp[i-1][j];
				dp[i][j] %= 10007;
			}
		}

	
//		 System.out.println(Arrays.deepToString(dp));

	
		System.out.println(dp[n][h]);
		
	}
	/*
	 * dp[1][2]=dp[0][0]=1
	 * dp[1][3]=dp[0][0]=1
	 * dp[1][5]=dp[0][0]=1
	 * 
	 * dp[2][3]=dp[1][3]+dp[1][0]=1+1=2
	 * dp[2][4]=dp[1][4]+dp[1][1]=0+0=0
	 * dp[2][5]=dp[1][5]+dp[1][2]=1+1=2
	 * dp[2][5]=dp[2][5]+dp[1][0]=2+1=3
	 * 
	 * 이전 사람이 블록을 쓰는 모든 경우 + 이전 사람이 안쓰고 내가 모든 블록을 쓰는 경우  
	 * 
	 */
}
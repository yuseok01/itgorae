package BaekJoon_Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_DP_9_내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int n = Integer.parseInt(br.readLine());
		
		int [][]stairs = new int[n][3];
		int [][] minDp = new int[n][3];
		int [][] maxDp	= new int[n][3];
		for(int i = 0 ; i < n ; i++	) {
			st=new StringTokenizer(br.readLine());
			stairs[i][0] = Integer.parseInt(st.nextToken());
			stairs[i][1] = Integer.parseInt(st.nextToken());
			stairs[i][2] = Integer.parseInt(st.nextToken());
		}
		minDp[0][0] = maxDp[0][0] = stairs[0][0];
		minDp[0][1] = maxDp[0][1] = stairs[0][1];
		minDp[0][2] = maxDp[0][2] = stairs[0][2];
		
		for(int i = 1 ; i < n; i++) {
			for(int j = 0; j<3 ; j++) {
				if(j==0) {
					minDp[i][j] += stairs[i][j]+ Math.min(minDp[i-1][0], minDp[i-1][1]);
					maxDp[i][j] += stairs[i][j]+ Math.max(maxDp[i-1][0], maxDp[i-1][1]);
				}
				if(j==1) {
					minDp[i][j] += stairs[i][j]+ Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]),minDp[i-1][2]);
					maxDp[i][j] += stairs[i][j]+ Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]),maxDp[i-1][2]);
				}
				if(j==2) {
					minDp[i][j] += stairs[i][j]+ Math.min(minDp[i-1][1], minDp[i-1][2]);
					maxDp[i][j] += stairs[i][j]+ Math.max(maxDp[i-1][1], maxDp[i-1][2]);
				}
			}
		}
		System.out.print(Math.max(Math.max(maxDp[n-1][0], maxDp[n-1][1]), maxDp[n-1][2])+ " ");
		System.out.println(Math.min(Math.min(minDp[n-1][0], minDp[n-1][1]), minDp[n-1][2])+ " ");
	}
}

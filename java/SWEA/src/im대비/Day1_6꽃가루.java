package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day1_6꽃가루 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc ; t++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int [][]map = new int[a][b];
			
			for(int i = 0; i < a ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < b ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxSum = 0;
			int []dx = {1, -1 , 0, 0};
			int []dy = {0, 0, -1, 1};
			for(int i =0 ; i < a ; i++) {
				for(int j = 0 ; j < b ; j++) {
					int sum= map[i][j]; 
					for(int k = 0 ; k < 4; k++) {
						int idx = i+dx[k];
						int idy = j+dy[k];
						if(0<=idx && idx<a && 0<= idy && idy < b ) {
							sum +=map[idx][idy];
						}
						
					}
					maxSum = Math.max(maxSum, sum);
				}
			}
			System.out.println("#"+t+" "+maxSum);
			
		}
	}

}

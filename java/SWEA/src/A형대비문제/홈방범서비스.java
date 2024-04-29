package A형대비문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홈방범서비스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/*
		 * 4중포문
		 */
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int[][] arr = new int[8][3];
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < y; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}int max = Integer.MIN_VALUE;
			for(int i = 0; i < x; i++) {
				for(int j = 0 ; j < y ;j++) {
					
					
					for(int dx = x-n ; dx <  )
				}
			}
		}
	}
}

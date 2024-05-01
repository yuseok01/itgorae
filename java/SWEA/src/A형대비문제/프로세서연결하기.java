package A형대비문제;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프로세서연결하기 {
	private static int[][] map;
	private static int n;
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	private static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int tc = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==0 || j==0 || i==(n-1)||j==(n-1)) {
					map[i][j] = 2;
				}
			}
		}
		
		for(int i = 0 ; i< n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(map[i][j]==1) {
					cnt = Integer.MAX_VALUE;
					dfs(i,j);
				}
			}
		}
	}

	static void dfs(int x, int y) {
			/*
			 * 1.boolean을 어디다가 초기화할지
			 * 2.cnt를 어디서 초기화할지
			 * 3.minCnt를 어디서 볼지
			 */
		boolean [][] checked = new boolean[n][n];
		checked[x][y] = true;
		for(int k = 1; k <=4 ; k++) {
			for(int l = 1; l < n-1 ; l++) {
				int idx = x + (l*dx[k]);
				int idy = y + (l*dy[k]);
				
				if(0<= idx && idx < n && 0<=idy && idy < n ) {//벽이면 
					dfs(idx,idy);
				}
				else {
					
				}
			}
		}
			
		
		
		
	}
}

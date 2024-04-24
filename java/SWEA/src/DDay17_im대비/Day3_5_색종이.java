package im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_5_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken());
		int[][] map = new int[1001][1001];
		int[] result = new int[num];
		int color = 1;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int c = a; c <a+x; c++) {
				for (int r = b; r < b+y; r++) {
					map[c][r] = color;
				}

			}
			color++;
		}
		for(int i = 0 ; i <1001 ; i++) {
			for(int j = 0; j<1001 ; j++) {
				for(int k = 1; k <= num ; k++) {
					if(map[i][j]==k) {
						result[k-1]++;
					}
				}
			}
		}
		for(int i = 0 ; i < num ; i++) {
			System.out.println(result[i]);
		}
	}
}

//2 장수 
//0 0 10 10  00부터 10 행 10열
//2 2 6 6
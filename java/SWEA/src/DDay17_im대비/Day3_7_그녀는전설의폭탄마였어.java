package DDay17_im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_7_그녀는전설의폭탄마였어 {
	static int[][] map;
	static int[] dx1 = { -1, 1, 0, 0 };
	static int[] dy1 = { 0, 0, -1, 1 };
	static int[] xdx1 = { -1, -1, 1, 1 };
	static int[] xdy1 = { -1, 1, -1, 1 };
	static int power;
	static int case1;
	static int casex;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) { // tc 시작
			st = new StringTokenizer(br.readLine());
			int mapsize = Integer.parseInt(st.nextToken());
			power = Integer.parseInt(st.nextToken());
			map = new int[mapsize][mapsize];

			for (int i = 0; i < mapsize; i++) { // 맵 입력 시작
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < mapsize; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 종료
			
			int max = 0;
			int result = 0;
			for (int i = 0; i < mapsize; i++) {
				for (int j = 0; j < mapsize; j++) {
					case1 = map[i][j];
					for(int k = 0 ; k<4 ; k++) {
						for(int l=1; l<=power; l++) {
							int idx = i + l*dx1[k];
							int idy = j + l*dy1[k];
							if( 0<= idx && idx < mapsize && 0<=idy && idy < mapsize) {
								case1 += map[idx][idy];
							}
						}
					}
					if(max < case1) {
						max=case1;
					}
					
				}
			}
			int xMax = 0; 
			for (int i = 0 ; i< mapsize; i++) {
				for(int j = 0; j< mapsize; j++) {
					casex = map[i][j];
					for(int k = 0 ; k < 4; k++) {
						for(int l = 1 ; l<=power; l++) {
							int idx = i+ l * xdx1[k];
							int idy = j+ l * xdy1[k];
							if(0<=idx && idx < mapsize && 0<=idy && idy <mapsize) {
								casex += map[idx][idy];
							}
						}
					}
					if(xMax < casex) {
						xMax = casex;
					}
				}
			}
			result = Math.max(max, xMax);
			System.out.println("#"+t+" "+result);
		}
	}
}

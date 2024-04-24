package BeakJoon;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 체스판1 {
	static int M;
	static int N;
	static char arr[][];
	static boolean check[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new char[M][N];
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = tmp.charAt(j);
			}
		}
		int min = 100;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i + 7 < M && j + 7 < N) {
					findDif(i, j);
					System.out.println(i+" "+j+"일때" +cnt);
						
					if (min > cnt) {
						min = cnt;
						
					}
				}
			}
		}
		System.out.println(min);

	}

	static void findDif(int c, int r) {
		cnt = 0;
		check = new boolean[M][N];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char tmp = arr[c + i][r + j];
				for (int k = 0; k < 4; k++) {
					int idx = c + i + dx[k];
					int idy = r + j + dy[k]; 
					if (0 <= idx && idx < M && 0 <= idy && idy < N && !check[idx][idy] && !check[c+i][r+j]) {
						if (tmp == arr[idx][idy]) {
//							System.out.println(idx+", "+idy+"는 true 쳌");
							cnt++;
							check[idx][idy] = true;

						}
					}
				}
			}
		}
	}
}
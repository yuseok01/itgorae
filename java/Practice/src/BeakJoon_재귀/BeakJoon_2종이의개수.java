package BeakJoon_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 
 * 어떻게 재귀적으로 행 열의 크기를 확인할 것인가?
 * 어떻게 재귀적으로 배열의 크기를 줄일 것인가?
 * for(int r= i ; r < i+n ; r += newN) { 
			for(int c = j ; c < j+n ; c +=newN) {
 * 
 */



public class BeakJoon_2종이의개수 {
	static int cntM1;
	static int cnt0;
	static int cntP1;
	static int n;
	static int[][] arr;
	static int i = 0;
	static int j = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		check(0, 0, n);
		System.out.println(cntM1);
		System.out.println(cnt0);
		System.out.println(cntP1);

	}

	static void check(int i, int j, int n) {
		if (isTrue(i, j, n)) {
			int num = arr[i][j];
			if(num == 0)
				cnt0++;
			if(num == -1)
				cntM1++;
			if(num == 1)
				cntP1++;
			return;
		}
		int newN = n/3;
		for(int r= i ; r < i+n ; r += newN) { 
			for(int c = j ; c < j+n ; c +=newN) {
				check(r,c,newN);
			}
		}

	}

	static boolean isTrue(int i, int j, int n) { //각 0,0위치랑 일치하는지 확인 i는 고정 
		for (int r = i; r < i + n; r++) {
			for (int c = j; c < j + n; c++) {
				if (arr[i][j] != arr[r][c]) {
					return false;
					}
			}
		}
		return true;

	}

}

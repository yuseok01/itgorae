package Dday27_조합_문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 제기 
 * 1명을 선택하는 경우 부터 N명까지 선택하는 모든 경우의 수를 모두 고려해야하는 문제 (PowerSet 부분집합)
 * 
 */
public class 과제_1_SWEA1486_1_장훈이의높은선반PowerSet부분집합 {
	static int[] arr;
	static int N; // 점원
	static int B; // 높이
	static boolean[] check;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t<= tc ; t++) {
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N] ; // n명의 점원이 존재
			check = new boolean[N];
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N ;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			powerSet(0);
			
			System.out.println("#"+t+" "+(result-B));
		}
	}

	static void powerSet(int idx) {
		if (idx == N) { // 모든직원 다 고려했어
			int sum = 0; // 현재 탑의 높이
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					sum += arr[i];
				}
			}
			if (sum >= B) {
				result = Math.min(result, sum);
			}
			return;
			
		}

		check[idx] = true; // 해당 직원 쌓아
		powerSet(idx + 1);

		check[idx] = false; // 해당 직원 나가 있어
		powerSet(idx + 1);
	}
}

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
public class 과제_1_SWEA1486_1_장훈이의높은선반PowerSet부분집합3 {
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
			int rs = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N ;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				rs += arr[i];
			}
			powerSet(0, 0, rs);
			//rs는 앞으로 내가 쌓을 수 있는 높이
			System.out.println("#"+t+" "+(result-B));
		}
	}

	// idx : 지금 선택할지 말지 결정할 직원
		// sum : 내가 지금까지 쌓아온 탑의 높이!
		// rsum : 앞으로 내가 쌓을 수 있는 탑의 높이!
		public static void powerSet(int idx, int sum, int rsum) {
			// 내가 현재 가지고 있는 최고의 값 ans를
			// 이미 벗어난 sum? 그 탑? 필요없어!
			if (sum > result)
				return;
			// 지금 내가 가지고 있는 탑의 높이와 앞으로 쌓을 수 있는 탑의 높이의 합이
			// B : 선반의 높이가 안되면 애초에 그건 답이 될 수 없어!
			if (sum + rsum < B) // 내가 가지고 있는 sum과 남은 rsum을 합처도 b가 안된다
				return;

			// 기저조건
			if (idx == N) { // 이제 모든 직원 다 고려했어!
				if (sum >= B)
					result = Math.min(result, sum);
				return;
			}
			
			// 재귀조건
			powerSet(idx + 1, sum + arr[idx], rsum - arr[idx]); // 쌓고 가고
			powerSet(idx + 1, sum, rsum - arr[idx]); // 안쌓고 가고
		}
	}


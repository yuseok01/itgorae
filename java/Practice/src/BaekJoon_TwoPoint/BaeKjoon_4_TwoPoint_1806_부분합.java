package BaekJoon_TwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaeKjoon_4_TwoPoint_1806_부분합 {
	private static int start;
	private static int end;
	private static int[] arr;
	private static int S;
	private static int N;
	static int maxCnt;
	static int sum;
	static int length;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		start = 0;
		end = 0;
		sum = 0;
		length = Integer.MAX_VALUE;
		while (start <= end && end <= N) { // 경계설정
			if (sum < S) {
				sum += arr[end++];
			} else if (sum >= S) {
				length = Math.min(length, end-start); //길이 초기화 하고 
				sum -= arr[start++]; // 갯수 줄여보자
			}
		}
		if(length == Integer.MAX_VALUE) { //한번도 sum이 컸던적이 없었다.
			System.out.println(0);
		}else {
			System.out.println(length);
		}
	}
}

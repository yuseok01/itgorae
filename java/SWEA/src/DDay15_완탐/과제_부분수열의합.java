package DDay15_완탐;

import java.util.Scanner;

public class 과제_부분수열의합 {
	static int n;
	static int k;
	static int[] arr;
	static int cnt;
	static int sum;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt(); // 수열의 갯수
			k = sc.nextInt(); // 찾고자하는 합
			check = new boolean[n];
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			cnt = 0;
			sum = 0;
			dfs(0);
			System.out.println("#"+t+" "+cnt);
		}
	}

	static void dfs(int idx) {
		if (idx >= n) { // 4인데 
			int tmp = 0;
			for (int i = 0; i < n; i++) {
				if (check[i]) {
					tmp += arr[i];
					/*
					if (tmp == k) {
						cnt++;
					}
					*/
				}
				
			}System.out.println(tmp);
			if(tmp == k) {
				cnt++;
			}
			return;

		}//1 2 1 2 마지막 인덱스 3 
		check[idx] = true;
		dfs(idx + 1);
		check[idx] = false;
		dfs(idx + 1);
	}

}

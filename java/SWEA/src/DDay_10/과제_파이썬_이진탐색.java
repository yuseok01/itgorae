package DDay_10;

import java.util.Scanner;

public class 과제_파이썬_이진탐색 {

	static int[] tree;
	static int value = 1;
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {

			N = sc.nextInt();

			tree = new int[N + 1]; // 0은 버리자

			inOrder(1);

			System.out.println("#" + tc + " " + tree[1] + " " + tree[N / 2]);

			value = 1;

		}

	}

	static void inOrder(int idx) {

		if (idx <= N) {
			inOrder(2 * idx);
			tree[idx] = value++;
			inOrder(2 * idx + 1);
		}

	}

}
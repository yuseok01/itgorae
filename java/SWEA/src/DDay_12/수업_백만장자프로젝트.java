package DDay_12;

import java.util.Scanner;

public class 수업_백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			long answer = 0;
			// 뒤에서부터 지금까지 나온 최댓값 갱신

			int[] max = new int[N];
			max[N - 1] = arr[N - 1];

			for (int i = N - 2; i >= 0; i--) {
				if (arr[i] > max[i + 1]) {
					max[i] = arr[i];
				} else {
					max[i] = max[i + 1];
				}

				answer += max[i] - arr[i];
			}

			System.out.println("#" + test_case + " " + answer);

		}

	}

}
package DDay15_완탐;

import java.util.Arrays;

public class 수업_부분집합_비트마스크 {
	public static void main(String[] args) {
		String[] 재료 = { "단무지", "참치", "햄", "소고기" };
		int N = 4; // 재료는 4개
		int[] sel = new int[N];

		// N개의 재료를 이용하여 만들 수 있는 모든 경우의 수
		for (int i = 0; i < (1 << N); i++) {
			// i라는 값은 -> 부분집합의 값인걸 알았는데
			// i의 재료가 무엇인지를 알수가 없다.
			String tmp = "";
			for (int j = 0; j < N; j++) { // 재료 검사!
				// 1이라고 하는 값을 j번 << 하면서 값을 비교한다.
				// 서5 오유진 서5 최다환 (명예)
				if ((i & (1 << j)) > 0) {
					tmp += 재료[j];
				}
			}
			System.out.println(tmp);
		}

	}
}


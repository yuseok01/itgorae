package DDay15_완탐;

import java.util.Arrays;

public class 수업_부분집합_재귀함수 {
	static String[] 재료 = { "단무지", "참치", "햄", "소고기" };
	static int N; // 재료 개수
	static boolean[] sel; // 재료의 사용유무

	public static void main(String[] args) {
		N = 4;
		sel = new boolean[N];

		powerset(0);
	}

	// idx : 해당 재료의 인덱스
	public static void powerset(int idx) {
		// base case : 재귀를 빠져나갈 조건
		if (idx >= N) {
			String tmp = "";
			for (int i = 0; i < N; i++) {
				if (sel[i])
					tmp += 재료[i];
			}
			System.out.println(tmp);
			return; //대전 일동;
		}
		// recursive case : 나 자신을 다시 호출하는 부분
		sel[idx] = true;// 이번 재료 넣었어!
		powerset(idx + 1); // 다음 재료 판단 해줘잉~~

		sel[idx] = false;
		// 이번 재료 안넣었어!
		powerset(idx + 1); // 다음 재료 판단 해줘잉~~

	}
}

package DDay18_빽트래킹;

import java.util.Arrays;

public class 수업_순열_3_방문체크 {
	static int[] nums; // 배열
	static int N; // 원소수

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;
		
		perm(0);
	}

	// idx : 현재 판단하는 위치
	public static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}

		// 재귀조건
		for (int i = idx; i < N; i++) {
			// (i, idx)의 위치를 swap
			swap(i, idx);
			perm(idx + 1);
			// (i, idx)의 위치를 swap (원상복구하는 과정)
			swap(i, idx);
		}

	}

	// nums 가 static하게 선언이 되어있으니까 쓸수 있다.
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

}

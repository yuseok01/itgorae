package Day_1;

import java.util.Scanner;

public class Ploblem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int k = 0; k < 10; k++) {
			int t = sc.nextInt();
			int sumResult = 0;
			int[] arr = new int[t];
			for (int i = 0; i < arr.length; i++) {
				int build = sc.nextInt();
				arr[i] = build; // 사용자 입력 빌딩 완성!
			}
			for (int i = 2; i < arr.length - 2; i++) { // 처음 끝 두칸 0으로 시작
				if (arr[i - 1] < arr[i] && arr[i - 2] < arr[i] && arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) {
					int left1 = arr[i] - arr[i - 2];
					int left2 = arr[i] - arr[i - 1];
					int right1 = arr[i] - arr[i + 1];
					int right2 = arr[i] - arr[i + 2];
					int leftMax = Math.min(left1, left2); // 왼쪽 건물과 현재건물 차이중 가장 작은 값
					int rightMax = Math.min(right1, right2); // 오른쪽 건물과 현재건물 차이중 가장 작은 값
					int arrountMax = Math.min(leftMax, rightMax); // left1,2 right 1,2 중에서 가증 작은 값 출력 // 주변 건물 중 가장 큰
																	// 건물과의 차이 출
					sumResult += arrountMax;
				}

			}
			System.out.println("#" + (k + 1) + " " + sumResult);
		}
	}

}

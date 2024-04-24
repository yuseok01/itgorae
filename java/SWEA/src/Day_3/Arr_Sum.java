package Day_3;

import java.util.Arrays;
import java.util.Scanner;

public class Arr_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arr[][] = new int[100][100];
		
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int maxXsum = 0;
			int maxYsum = 0;
			int maxXYsum = 0;
			int maxYXsum = 0;
			int superSum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = 0;
				}
			}
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					int input = sc.nextInt(); // 영역 전개
					arr[i][j] = input;
				}
			}

			for (int i = 0; i < 100; i++) { // 행 우선 선회 최대값
				int xSum = 0;
				for (int j = 0; j < 100; j++) {
					xSum += arr[i][j];
					if (xSum >= maxXsum) {
						maxXsum = xSum;
					}
					if (maxXsum >= superSum) {
						superSum = maxXsum;
					}
				}
			}
			for (int j = 0; j < 100; j++) { // 행 우선 선회 최대값
				int ySum = 0;
				for (int i = 0; i < 100; i++) {
					ySum += arr[i][j];
					if (ySum >= maxYsum) {
						maxYsum = ySum;
					}

					if (maxYsum >= superSum) {
						superSum = maxYsum;
					}
				}

			}
			for (int i = 0; i < 100; i++) {
				maxXYsum += arr[i][i];
				if (maxXYsum >= superSum) {
					superSum = maxXYsum;
				}
			}
			for (int i = 0; i < 100; i++) {
				maxYXsum += arr[i][99 - i];
				if (maxYXsum >= superSum) {
					superSum = maxYXsum;
				}
			}
			System.out.printf("#%d %d\n", tc, superSum);
		}
	}

}

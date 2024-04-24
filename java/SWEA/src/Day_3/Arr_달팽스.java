package Day_3;

import java.util.Scanner;

public class Arr_달팽스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];

			int num = 1;
			int rowStart = 0, rowEnd = N - 1, colStart = 0, colEnd = N - 1;

			while (rowStart <= rowEnd && colStart <= colEnd) {
				// 위쪽 행
				for (int i = colStart; i <= colEnd; i++) {
					snail[rowStart][i] = num++;
				}
				rowStart++;  

				// 오른쪽 열
				for (int i = rowStart; i <= rowEnd; i++) {
					snail[i][colEnd] = num++;
				}
				colEnd--;

				// 아래쪽 행
				for (int i = colEnd; i >= colStart; i--) {
					snail[rowEnd][i] = num++;
				}
				rowEnd--;

				// 왼쪽 열
				for (int i = rowEnd; i >= rowStart; i--) {
					snail[i][colStart] = num++;
				}
				colStart++;
			}

			// 출력
			System.out.printf("#%d\n", t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%d ", snail[i][j]);
				}
				System.out.println();
			}
		}
	}
}

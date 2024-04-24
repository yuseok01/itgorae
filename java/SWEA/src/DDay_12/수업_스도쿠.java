package DDay_12;

import java.util.Scanner;

public class 수업_스도쿠 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		TC: for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");  
			int[][] board = new int[9][9];

			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					board[r][c] = scanner.nextInt();
				}
			}

			// 행 체크 1차원 배열에 확인하면서 중복 확인 
			for (int r = 0; r < 9; r++) {
				int[] arr = new int[10];
				for (int c = 0; c < 9; c++) {
					int num = board[r][c];
					if (arr[num] >= 1) {
						// 잘못된 스도쿠
						System.out.println(0);
						continue TC;
					}
					arr[num]++;
				}
			}

			// 열 체크

			for (int c = 0; c < 9; c++) {
				int[] arr = new int[10];
				for (int r = 0; r < 9; r++) {
					int num = board[r][c];
					if (arr[num] >= 1) {
						System.out.println(0);
						continue TC;
					}
					arr[num]++;
				}
			}

			// 격자 체크 
			for (int sr = 0; sr < 9; sr += 3) {
				for (int sc = 0; sc < 9; sc += 3) {
					// 각 격자 시작지점들 찾은후 3x3 탐색
					int[] arr = new int[10];
					for (int r = sr; r < sr + 3; r++) {
						for (int c = sc; c < sc + 3; c++) {
							int num = board[r][c];
							if (arr[num] >= 1) {
								System.out.println(0);
								continue TC;
							}
							arr[num]++;
						}
					}
				}
			}
			
			// continue TC;에 걸린적이 없다면 중복이 없다 -> 정확한 스도쿠
			
			System.out.println(1);

		}

	}

}
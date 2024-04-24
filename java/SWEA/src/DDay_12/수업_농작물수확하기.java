package DDay_12;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class 수업_농작물수확하기 {

	/*
	 * 대전 3반 이윤주
	 */

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input1.txt"));

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 농장 한 변의 길이
			int N = sc.nextInt();

			int[][] board = new int[N][N];

			for (int r = 0; r < N; r++) {
				String line = sc.next();
				for (int c = 0; c < N; c++) {
					board[r][c] = line.charAt(c) - '0';
				}
			}

			// 마름모형태로 순회
			
			int sum = 0;
			int left = N / 2;
			int right = N / 2;

			// 위쪽 삼각형
			for (int r = 0; r < N / 2; r++) {
				for (int c = left; c <= right; c++) {
					sum += board[r][c];
				}
				left--;
				right++;
			}
			
			// 아래쪽 삼각형
			for (int r = N / 2; r < N; r++) {
				for (int c = left; c <= right; c++) {
					sum += board[r][c];
				}
				left++;
				right--;
			}
			
			System.out.println("#" + test_case + " " + sum);

		}

	}

}
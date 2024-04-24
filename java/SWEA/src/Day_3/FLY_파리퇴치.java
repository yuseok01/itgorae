package Day_3;

import java.util.Scanner;

public class FLY_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // tc입력
		for (int t = 0; t < tc; t++) {
			int N = sc.nextInt(); // 필드 설정
			int M = sc.nextInt(); // 죽이는 필드 설정
			int[][] arr = new int[N][N]; // 영역 전개
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int input = sc.nextInt();
					arr[i][j] = input; // 이중배열 채우기
				}

			}
			int[][] flyKill = new int[M][M]; // 영역 전개
			int[] nr = { 0, 0, 1, 1 };
			int[] nc = { 0, 1, 1, 0 };

			int killMax = 0; // 여기서해야 결과값 출력

			for (int i = 0; i <= N - M; i++) { // 배열 범위를 조정하여 겹치지 않도록 수정
				for (int j = 0; j <= N - M; j++) {
					int kill = 0; // kill 변수 위치 수정

					for (int x = 0; x < M; x++) { // x열
						for (int y = 0; y < M; y++) { // y열
							kill += arr[i + x][j + y]; // 배열 범위 조정
						}
					}

					if (kill > killMax) {
						killMax = kill;
					}
				}
			}
			System.out.printf("#%d %d\n", t + 1, killMax);
		}
	}
}

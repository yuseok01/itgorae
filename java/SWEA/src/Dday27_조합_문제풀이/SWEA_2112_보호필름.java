-1package Dday27_조합_문제풀이;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2112_보호필름 {
	static int D, W, K; // D : 행 (3~13), W : 열(1~20), K : 통과기준 (1~D)
	static int[][] film; // 보호필름 저장
	static int ans; // 최소 주사 투약 횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			} // 보호 필름 입력 완료

			ans = 987654321; // 이것도 좋지만 사실 K로 초기화 해도 좋음

			makeFilm(0, 0);

			System.out.println("#" + tc + " " + ans);

		} // tc
	}// main

	// row : 현재 약품을 주입할 행
	// cnt : 약품을 주입한 횟수
	public static void makeFilm(int row, int cnt) {
		///// 조건
		if (isOk()) {
			// 통과 기준을 넘어선것
			ans = Math.min(ans, cnt);
			return;
		}

		if (ans < cnt)
			return; // 내가 이미 값을 알고 있는데 투약 횟수가 많아지면 할필요없어.
		if (row == D)
			return; // 다해본거임

		//////////////////////// 재귀 파트는 끝
		// 주입 X
		makeFilm(row + 1, cnt);

		// 약품을 주입하기 전에 원상복구를 해야하니 메모리를 할당해서 저장을 해두자.
		int[] tmp = new int[W];
		for (int i = 0; i < W; i++) {
			tmp[i] = film[row][i];
		} // row행의 값을 딥카피 해서 저장해놓고 가지고 있겠다.

		// 주입 A
		yak(row, 0);
		makeFilm(row + 1, cnt + 1);

		// 주입 B
		yak(row, 1);
//		Arrays.fill(film[row], 1); //인젝션 아니여?
		makeFilm(row + 1, cnt + 1);

		// 원상복구 (투약 안한것처럼 되돌려놔)
		for (int i = 0; i < W; i++)
			film[row][i] = tmp[i];

//		film[row] = tmp;
	}

	// 모든 열이 연속된 특성이 K개 이상인가?
	private static boolean isOk() {
		for (int c = 0; c < W; c++) {
			boolean flag = false;
			int cnt = 1;
			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r - 1][c])
					cnt++; // 이전 특성과 같다면 추가
				else
					cnt = 1; // 이전 특성과 다르다면 나부터 다시쳌 이니까 1로 초기화
				if (cnt >= K) {
					flag = true;
					break;
				}
			} // 해당 열검사 완료
			if (!flag)
				return false;
		}
		// 여기까지 도착했는데 위에서 리턴이 되지 않았다면 이건 통과한거야!
		return true;
	}

	// row번째 행에다가 drug 약품을 주입하겠다!
	public static void yak(int row, int drug) {
		for (int i = 0; i < W; i++) {
			film[row][i] = drug;
		}
	}

}
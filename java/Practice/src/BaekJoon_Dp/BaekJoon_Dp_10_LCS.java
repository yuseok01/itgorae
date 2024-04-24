package BaekJoon_Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_Dp_10_LCS {
	/*
	 * 최장공통수열 길이 찾기 2차원 배열에 넣었을때 같은 값이 누적합이 됨을 이해하자 연속됨과 별계임
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();
		char[] aArr = new char[A.length() + 1];
		char[] bArr = new char[B.length() + 1];
		for (int i = 1; i < aArr.length; i++) {
			aArr[i] = A.charAt(i - 1);
		}
		for (int i = 1; i < bArr.length; i++) {
			bArr[i] = B.charAt(i - 1);
		}

		int [][] DP = new int[A.length() + 1][B.length() + 1];

		for (int i = 1; i < A.length() + 1; i++) {
			for (int j = 1; j < B.length() + 1; j++) { //어쨋든 제일 큰값만 계속 누적해주면됨 대각선 위 vs 왼쪽 vs 위쪽
				if (aArr[i] == bArr[j]) {
					DP[i][j] = DP[i-1][j-1]+1;
				}
				else {
					DP[i][j] = Math.max(DP[i - 1][j], DP[i][j-1]);
				}
			}
		}
		System.out.println(DP[A.length()][B.length()]);
	}
}

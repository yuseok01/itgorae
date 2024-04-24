package DDay16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과제_거듭제곱 {
	static int C; 
	static int P; //power

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		for (int tc = 1; tc <= 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			int result = pow2(C, P);
			System.out.println("#" + tc + " " + result);
		}
	}

	public static int pow2(int C, int N) {
		// 기저조건
		if (N == 1)
			return C;

		int tmp;
		// 재귀부분 : 짝수일때와 아닐때를 나누어서 생각 하겠다.
		if (N % 2 == 0) { // (2)^2 * 2 홀수일때 ; 
			tmp = pow2(C, N / 2); 
			return tmp * tmp;
		} else {// 서5 양지웅 훌륭
			tmp = pow2(C, (N - 1) / 2);
			return tmp * tmp * C;
		}
	}
}

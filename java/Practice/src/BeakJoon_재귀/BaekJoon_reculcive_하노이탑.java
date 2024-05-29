package BeakJoon_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BaekJoon_reculcive_하노이탑 {
	static StringBuilder result = new StringBuilder();
	private static int res = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine()); // 탑의 갯수

		System.out.println(BigInteger.TWO.pow(cnt).subtract(BigInteger.ONE));
		// 2^n - 1

		if (cnt <= 20) {

			hanoi(cnt, 1, 2, 3); // 매개변수 이동할 원판, 1번탑, 2번탑, 3번탑,

			System.out.println(result.toString());

		}

	}

	private static void hanoi(int cnt, int from, int temp, int to) {
		if (cnt == 0)
			return;
		//flat하게 생가하기 
		hanoi(cnt - 1, from, to, temp);  //n-1번째가 from에서 to로 가야해
		res++;
		result.append(from + " " + to + "\n");

		hanoi(cnt - 1, temp, from, to); //옮겼으면 n-1번째가 from에서 to로 가야해 

	}
}

package BaekJoon_num;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1_1747_소수팰린드롬 {
	static boolean prime[] = new boolean[1004002];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		isPrime();

		for (int i = n; i < 1000001; i++) {
			if (!prime[i]) {
				String str = String.valueOf(i);
				StringBuffer sb = new StringBuffer(str);
				String reverseStr = sb.reverse().toString();

				if (str.equals(reverseStr)) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	static void isPrime() { // 소수인지 아닌지 확인하는 메서드 
		prime[0] = prime[1] = true; //0과 1은 소수가 아님
		//에라토스테네스의 체 제곱 수들 소수 체크   
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) {
				continue;
			}

			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}
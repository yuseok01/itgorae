package Day_6_스택_재귀;

import java.util.Scanner;

public class Day6_거듭제곱_재귀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int num = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			int result = pow(a, b);
			System.out.println("#" + tc + " " + result);

		}

	}



	public static int pow(int a, int b) {
		
		if (b == 0) {
			return 1;
		} else {
			return a * pow(a,b-1);

		}

	}
}

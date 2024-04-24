package DDay_10;

import java.util.Scanner;

public class 과제_사칙연산 {
	static int n;
	static String[][] arr;
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			n = sc.nextInt();
			sc.nextLine();
			arr = new String[n + 1][];
			for (int i = 1; i <= n; i++) {
				String input = sc.nextLine();
				arr[i] = input.split(" ");
			}
			System.out.print("#" + tc + " ");

			calcul(1);
			System.out.println(result);

		}
	}

	static int calcul(int i) {

		if (arr[i][1].equals("+")) {
			if (arr[i].length >= 4) {
				int oper = calcul(Integer.parseInt(arr[i][2]));
				int oper2 = calcul(Integer.parseInt(arr[i][3]));
				result = oper + oper2;
				return result;
			}
		} else if (arr[i][1].equals("-")) {
			if (arr[i].length >= 4) {
				int oper = calcul(Integer.parseInt(arr[i][2]));
				int oper2 = calcul(Integer.parseInt(arr[i][3]));
				result = oper - oper2;
				return result;
			}

		} else if (arr[i][1].equals("/")) {
			if (arr[i].length >= 4) {
				int oper = calcul(Integer.parseInt(arr[i][2]));
				int oper2 = calcul(Integer.parseInt(arr[i][3]));
				result = oper / oper2;
				return result;
			}

		} else if (arr[i][1].equals("*")) {
			if (arr[i].length >= 4) {
				int oper = calcul(Integer.parseInt(arr[i][2]));
				int oper2 = calcul(Integer.parseInt(arr[i][3]));
				result = oper * oper2;
				return result;
			}

		} else {
			result = Integer.parseInt(arr[i][1]);
			return result;

		}
		return result;
	}
}

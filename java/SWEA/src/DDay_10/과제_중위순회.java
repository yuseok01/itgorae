package DDay_10;

import java.util.Scanner;

//LVR
public class 과제_중위순회 {
	static String[][] num;
	static int N ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			sc.nextLine();

			num = new String[N + 1][];

			for (int i = 1; i <= N; i++) {
				String input = sc.nextLine();
				num[i] = input.split(" ");
			}
			System.out.print("#" + tc + " ");

			inOrder(1);
			System.out.println();
		}

	}

	static void inOrder(int index) {
		if (Integer.parseInt(num[index][0])<=N) {
			if (num[index].length >= 3) {
				inOrder(Integer.parseInt(num[index][2]));
			} // 왼쪽 자식
			
			System.out.print(num[index][1]); // 현재 값 출력

			if (num[index].length >= 4) {
				inOrder(Integer.parseInt(num[index][3])); // 오른쪽 자신
			}
		}
	}
}

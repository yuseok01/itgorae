package Day_2;

import java.util.Arrays;
import java.util.Scanner;

public class Dump {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t<10 ; t++) {
			int dumpCount = sc.nextInt();
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				int boxHigh = sc.nextInt();
				arr[i] = boxHigh; // 박스 구성
			}

			for (int i = 0; i < dumpCount; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;

			}
			Arrays.sort(arr);
			int result = arr[99] - arr[0];
			System.out.printf("#%d %s\n", t + 1, result);
		}
	}

}

package DDay_12;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 과제_단조증가하는수 {
	static String[] arr;
	static boolean isDan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int result = -1;
			int N = sc.nextInt(); // 배열의 크기
			
			arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();  //문자열로 입력받기 
				check(arr[i], N); //단조 확인
				if (isDan) {
					
				}
			System.out.println("#"+t+" "+a);
			
		}
	}

	static void check(String a, int N) {

		for (int i = 0; i < a.length() - 1; i++) {
			if (a.charAt(i) <= a.charAt(i + 1)) {
				isDan = true;
			} else {
				isDan = false;
			}
		}

	}

}

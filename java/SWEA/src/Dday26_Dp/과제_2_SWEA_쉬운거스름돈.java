package Dday26_Dp;

import java.util.Scanner;

public class 과제_2_SWEA_쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 1 ; t <= tc ; t++) {
			int Money = sc.nextInt();
			//5만원권 만원권 오천원권 천원건 오백원권 백원권 오십원 십원
			int [] result = new int[8];
			int [] mon = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			for(int i = 0; i< 8; i++) {
				result[i] = Money/mon[i];
				Money = Money % mon[i];
			}
			System.out.println("#"+t);
			for(int i = 0; i < 8; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
	}
}

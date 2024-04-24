package Day_2;

import java.util.Scanner;

public class Selection {// 선택알고리즘
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				int input = sc.nextInt();
				arr[i] = input;
			}
			int min = 0;
			int temp = 0;
			for (int i = 0; i <n; i++) {
				for (int j = i + 1; j < n ; j++) {
					if (arr[i] > arr[j]) {
						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			System.out.print("#"+t+" ");
			for(int i = 0 ; i < n ; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
		}
	}

}

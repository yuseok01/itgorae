package im대비;

import java.util.Scanner;

public class Day1_4점점커지는당근 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int before = 0;
			int maxcount = 1;
			int cnt = 0;
			int[] arr = new int[sc.nextInt()];
		
			
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if(arr[i]> before) {
					cnt++;
					if(cnt> maxcount) {
						maxcount=cnt;
					}
				}
				else {
					cnt =1;
				}
				before = arr[i];

			}
			System.out.println("#" + t + " " + maxcount);
		}

		// 4 5 1 2 3
	}
}
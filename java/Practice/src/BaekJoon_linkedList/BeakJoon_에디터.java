package BaekJoon_linkedList;

import java.util.Scanner;

public class BeakJoon_에디터 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i];
			}
		}double sum = 0;
		for(int i = 0 ; i < n ; i ++) {
			sum += (double) arr[i] / max *100;
		}
		System.out.println(sum / n);

	}

}

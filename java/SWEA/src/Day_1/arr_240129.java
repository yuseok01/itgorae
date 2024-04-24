package Day_1;

import java.util.Scanner;

public class arr_240129 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0 ; t < tc ; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int tem = 0; 
			for(int i = 0 ; i < n ; i++) {
				int n1 = sc.nextInt();
				arr[i] = n1;  // 배열 입력끝 
			}
			for(int i = n-1 ; i > 0 ; i-- ) {
				for(int j = 0 ; j < i ; j++) {
					if(arr[j]>arr[j+1]) {
						tem = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tem; // 배열 정렬
					}
				}
			}
			for(int i = 0 ; i < 1 ; i++) { 
				System.out.println();
				System.out.printf("#%d ",t+1); 
				for(int j = 0 ; j < n ; j++) {
					System.out.print(arr[j]+" ");
					
				}
			}
		}	
	}
}
package Day_1;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int [][] arr = new int[t][10];
		
		for(int i = 0 ; i <arr.length ; i++ ) {
			for(int j = 0 ; j < arr[0].length ; j++) {
				int input = sc.nextInt();
				arr[i][j] = input;				
			}
		}
		int [] max = new int[t];
		
		
		for(int i=0; i < t ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				if( max[i] < arr[i][j]) {
					max[i] = arr[i][j];
				}
				
					
				}
			}
		
		for(int i = 0; i < t ; i++) {
			System.out.println("#"+(i+1)+" "+max[i]);
		}
	}
}

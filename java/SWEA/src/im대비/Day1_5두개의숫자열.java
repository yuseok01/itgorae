package im대비;

import java.util.Scanner;

public class Day1_5두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t =1; t<=tc ; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int [] A = new int[a];
			int [] B = new int[b];
			
			for(int i =0 ; i < a ; i++) {
				A[i] = sc.nextInt();
			}
			for(int i =0 ; i < b ; i++) {
				B[i] = sc.nextInt();
			}
			int sum;
			int maxSum =0;
			if(a<b) {
				for(int i = 0; i<= b-a ; i++) {//많은놈이 가만히있는놈
					sum = 0;
					for(int j = 0 ; j<a ; j++) {
						sum +=  B[i+j] * A[j];
					}maxSum = Math.max(maxSum, sum); //계산한 sum 값 max값에 저장
				}
			}
			else {//a>b
				for(int i =0; i<= a-b; i++) {//많은놈이 가만히있는놈
					sum = 0; //한가지 경우에수 시작할때마다 초기화 
					for(int j= 0 ; j <b ; j++) { //!! 큰놈 배열까지 움직이면 터짐 
						sum+= A[i+j] * B[j];
					}maxSum = Math.max(maxSum, sum);
				}
			}
			System.out.println("#"+t+" "+maxSum);
			
		}
	}
}

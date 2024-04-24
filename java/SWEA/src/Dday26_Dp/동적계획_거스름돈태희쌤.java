package Dday26_Dp;

import java.util.Scanner;

public class 동적계획_거스름돈태희쌤 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc .nextInt(); //목표금액
		int [] d = new int[n+1]; //각 금액을 만드는 최소 동전수 
		
		d[0] = 0;
		for(int i = 1 ; i <= n ;i++) { //n원까지
			int min = d[i-1] +1; //1원 사용
			if(i>=4) min = Math.min(d[i-4]+1, min);
			if(i>=6) min = Math.min(d[i-6]+1, min);
			d[i] = min;
			
		}
		System.out.println(d[n]);
	}
}

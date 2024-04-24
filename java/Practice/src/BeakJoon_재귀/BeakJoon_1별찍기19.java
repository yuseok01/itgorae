package BeakJoon_재귀;

import java.util.Scanner;

public class BeakJoon_1별찍기19 {
	static char [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = 4*N -3; 
		arr = new char[M][M];
		
		for(int i = 0 ; i < M;i++) {
			for(int j =0 ; j<M ; j++) {
				arr[i][j]= ' '; 
				
			}
		}
		result(0 , M);
		
		for(int i = 0 ; i < M ; i++) {
			
			for(int j = 0 ; j <M ; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
		
		public static void result(int n, int M	) {
			for(int i = n ; i < M ; i++) {
				//바깥 부터 채우기 
				arr[n][i] = '*'; //위에
				arr[i][n] = '*'; //왼쪽 
				arr[i][M-1] = '*'; //오른쪽
				arr[M-1][i] = '*'; //아래
				//M 1 5 9		
			
			}
			
			if(M == 1) return; 
			result(n+2,M-2);
		
	}
		
}

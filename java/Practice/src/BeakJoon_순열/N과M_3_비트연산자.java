package BeakJoon_순열;

import java.util.Scanner;
 
public class N과M_3_비트연산자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int []arr=new int[n+1];
		for(int i =1; i<= n; i++ ) {
			arr[i] = i;
		}
		for(int i = 1; i<=(1<<n);i++) { // 배열끝까지 가기 
			
			for(int j=1; j<=n ;j++) { //출력할 길이 
				if((i & (1<<n))>0) {
					System.out.print(arr[j]+" ");
				}
			}System.out.println();
		}
	}
	
	
 
}
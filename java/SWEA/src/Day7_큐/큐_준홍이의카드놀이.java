package Day7_큐;

import java.util.Arrays;
import java.util.Scanner;

public class 큐_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();// tc 입력
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] count = new int[n + m +2]; // 인덱스 번호가 합인 배열
			int[][] arr = new int[n][m]; // 합의 집합 이중배열
			int[] result = new int[n+m];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					arr[i][j] = i + j + 2;
					count[i + j + 2]++;
				}
			}
			int max=0;                                 /////////////////////////////복수의 최대값 인덱스 출력 ->맥스 값찾고 맥스값이랑 같으면 i출력  
			for(int i = 0 ; i < count.length ; i++) {
				max = Math.max(max, count[i]);
			}
			System.out.print("#"+t+" ");
			for(int i = 0; i < count.length;i++) {
				if(count[i]==max) {
					System.out.print(i+" ");
				}
			}System.out.println();                     ////////////////////////////
		}
	}
}

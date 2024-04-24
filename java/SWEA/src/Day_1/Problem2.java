package Day_1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // x열 입력
		int [][] arr = new int[t][10];
		for(int i = 0 ; i < t ; i++) {
			for(int j = 0 ; j < 10; j++) {
				int input = sc.nextInt();
				arr[i][j] = input;
			}//2중배열 완성 
		}
		int [] max = new int[t];
		int [] min = new int[t];
		Arrays.fill(min, 10000); //초기 min 값 10000설정
		int [] sum = new int[t];
				
		for(int i = 0 ; i<t ; i++) {
			for(int j = 0 ; j < 10 ; j++) {
				sum[i]+=arr[i][j];
				
				if(max[i] < arr[i][j]) {
					max[i]=arr[i][j]; //각 i 열 최대값 초기화
				}
				if(min[i] > arr[i][j]) {
					min[i]=arr[i][j]; //각 i 열 최소값 초기화
				}
			
			}
		}
		for(int i = 0 ; i < t ; i++) {
			System.out.println("#"+(i+1)+" "+ Math.round((sum[i] - max[i] - min[i]) / 8.0));
			}
		
	}
}
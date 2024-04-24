package BeakJoon;

import java.util.Scanner;

public class BeakJoon_0205_5430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int N = sc.nextInt(); //배열 길이
			int M = sc.nextInt(); 
			int [] arr = new int[N];
			for (int i = 0 ; i < N ; i++) {
				arr[i] = i+1;
			}
			int temp = 0;
			for(int i = 0 ; i < M ; i++) {
				int input1 = sc.nextInt();
				int input2 = sc.nextInt();
				for(int j = input1-1 ; j < input2-1;j++) {
					temp = arr[j];
					arr[j] = arr[input2-1];
					arr[input2-1] = temp;
					input2--;
				}
				
			}
			for(int i = 0 ; i < N ;i++) {
				System.out.print(arr[i]+" ");
			}
		}
}

package IM형대비문제;

import java.util.Arrays;
import java.util.Scanner;

public class Day1_1_2563색종이_BeakJoon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][]arr = new int[100][100];
		int n = sc.nextInt();
		
		int sum = 0;
		for(int i = 0; i< 100; i++) {
			Arrays.fill(arr[i],0);
		}
		
		for(int p = 0 ; p <n; p++) {
			int y= sc.nextInt();
			int x = sc.nextInt();	
			for(int i = x ; i< x+10 ; i++) {
				for(int j = y ; j<y+10 ; j++) {
					if(arr[i][j] == 0){
						arr[i][j]= 1;
						sum ++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}

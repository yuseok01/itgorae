package Day_1;

import java.util.Scanner;

public class Solution_Lv4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 0 ; t< tc ; t++) {
			System.out.println();			
			int hight = sc.nextInt();
			int [] arr = new int[hight];
			
			for(int i = 0 ; i < hight ; i++) {
				arr [i] = sc.nextInt();
				
			}
			int maxDrop	= 0;
			for(int i = 0 ; i < hight-1 ; i++) {
				int count = 0;
				for(int j =i+1 ; j < hight ; j++)
				if(arr[i]>arr[j]) {
					count++;	
					}
				if(maxDrop < count) {
					maxDrop = count;
				}
				
			}
			System.out.printf("#%d %d",t+1,maxDrop);
				
		}
	}

}

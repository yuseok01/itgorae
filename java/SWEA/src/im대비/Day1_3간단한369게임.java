package im대비;

import java.util.Scanner;

public class Day1_3간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]arr = new int[n+1];
		String result;
		for(int i = 1; i<=n ; i++) {
			//integer.toString(i) 
			//문자열.charAt(0~1)
			result = Integer.toString(i);
			int cnt = 0;
			for(int j = 0; j< result.length(); j++) {
				char a = result.charAt(j);
				if(a == '3' || a == '6' || a=='9') {
					cnt++;
				}
			}if(cnt==0) {
				System.out.print(i+" ");
				
			}
			else {
				for(int j = 0; j<cnt; j++) {
					System.out.print("-");
				}System.out.print(" ");
			}
		}
	}

}

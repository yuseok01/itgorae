package im대비;

import java.util.Scanner;

public class Day2_3_심심풀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int t = 0; t<tc ; t++) {
			int num = sc.nextInt();
			String st = sc.next();
			
			for(int i = 0; i <st.length() ; i++) {
				for(int j =0; j<num ; j++) {
					char input = st.charAt(i); 
					System.out.print(input);
				}
			}
			System.out.println();
			
		}
		
		
	}

}

package BeakJoon;

import java.util.Scanner;

public class 별짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int c = 0 ; c < tc ; c++) {
			
			for(int r = 0 ; r<tc ; r++) {
				if((c==0 && r==0 ) || (c==tc-1 && r==tc-1)) {
					System.out.print("*");
			
				}
				else {
					
				}
			}
		}
		
	}
}


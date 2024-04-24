package BeakJoon;

import java.util.Scanner;

public class BeakJoon_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m = sc.nextInt();
		int input = sc.nextInt();
		
		int totalMinutes = (t*60 + m +input) % (24 * 60);
		int newT = totalMinutes / 60 ; 
		int newM = totalMinutes % 60 ; 
		
		System.out.println(newT + " " + newM);
		
	}
}


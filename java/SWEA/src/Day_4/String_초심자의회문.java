package Day_4;

import java.util.Scanner;

public class String_초심자의회문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String string = sc.next();
		StringBuffer sb = new StringBuffer(string);
		sb.reverse();
		String reversed = sb.toString();
		if(reversed.equals(string)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
		
		
		

		
	}

}

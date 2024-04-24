package BeakJoon;

import java.util.Scanner;

public class BeakJoon_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int m = sc.nextInt();
		int T = t*60;
		int result = (T + m - 45)%60;
		if(m>=45) {
			System.out.println(t+" "+(m-45));
			}
		
		else if(t !=0 && m<45) {
			System.out.println((t-1)+" "+result);
		}	
		else if (t == 0 && m < 45) {
		
		System.out.println((23)+" "+ (60 + (m-45)) );
		}
	}
}


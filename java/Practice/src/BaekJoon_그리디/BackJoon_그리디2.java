package BaekJoon_그리디;

import java.util.Scanner;

/*
 *  "/10 +1을 하는게 우선 적용
 *  /2가 후순위 적용되는 것이 최단 거리임을 생각할수 있는지 문제
 *
 * 
 */
public class BackJoon_그리디2 {
	static int A;
	static int B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		int cnt = 1;
		while(B!=A) {
			
			if(B<A) {
				System.out.println(-1);
				System.exit(0); //강종
			}
			
			if(B%10==1) {
				B /= 10; //나머지 알아서 삭제
				cnt++;
			}else if(B%2==0) {
				B /= 2;
				cnt++;
				
			}else {
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(cnt);
	
		
	}
	

}

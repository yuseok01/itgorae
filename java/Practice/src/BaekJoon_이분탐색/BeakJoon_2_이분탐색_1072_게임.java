package BaekJoon_이분탐색;

import java.io.BufferedReader;
import java.util.Scanner;

/*
 * 생각 해보기 
 * 이진탐색 사용 조건 => 하나의 값을 반복적으로 증가 감소하면서 찾아야 할때
 * left =1 , right = maxValue(문제에서 주어진 최대값)
 * 
 * int z = (int)((double)y/(double)x *100)가 원하는 승률을 주는가? 
 * int z = (int)((long)y * 100/ x)은 원하는 승률을 주는가 
 * 
 * 소수점을 버려도 될때는long을 활용하여 버리자 
 
 */


public class BeakJoon_2_이분탐색_1072_게임 {
	public static void main(String[] args) {
//		double a = 0.57;
//		int k = (int)(a * 100);
//		System.out.println(k); //예상 57 답 56
				
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = (int)((long)y * 100/ x);

		int cnt = -1;
		int left = 0;
		int right = 1000000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			if ((int) (((long)(y + mid) * 100) / (x + mid)) != z) { // 승률이 바뀌었으면 판수를 낮추어 최적을 찾자
				cnt = mid;
				right = mid - 1;
			} else { // 승률이 바뀌었으면 판수를 증가시켜 승률을 바꾸어보자
				left = mid + 1;
			}
			
		}
		System.out.println(cnt);

	}

}

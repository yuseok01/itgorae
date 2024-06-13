//주사위 던지기 (던지는 횟수 6번 이하 )

import java.util.Arrays;
import java.util.Scanner;

public class class_순열 {
	static int n, numbers[];
	static boolean isSelected[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 주사위 던지는 횟수
		numbers = new int[n]; // 던지는 주사위 눈 저장할 배열 
		int mode = sc.nextInt(); // 주사위 게임 종류
		switch (mode) {
		case 1: //중복 가능 
			dice1(0);
			break;
		case 2:// 순열 : 중복관리 
			isSelected = new boolean[7];
			dice2(0);
			break;

		}

	}
	private static void dice1(int cnt) { //매개변수 던진횟수
		if(cnt == n ) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1 ; i <= 6; i++) {
			numbers[cnt] = i ; //첫번째 던진거에 i 넣기
			dice1(cnt+1); //다음 주사위 던지러 가기 플랫한 시야
			
			
		}
	}
	private static void dice2(int cnt) { //매개변수 던진횟수
		if(cnt == n ) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 1 ; i <= 6; i++) {
			if(isSelected[i]) {
				continue;
			}
			numbers[cnt] = i ; //첫번째 던진거에 i 넣기
			isSelected[i]= true;
			dice2(cnt+1); //다음 주사위 던지러 가기 플랫한 시야
			isSelected[i] = false; //되돌려놓기 
			
			
		}
	}
}

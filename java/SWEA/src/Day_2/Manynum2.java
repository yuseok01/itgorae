package Day_2;

import java.util.Arrays;
import java.util.Scanner;

public class Manynum2 {
	//학생 점수 배열  -> arr[점수] == [점수] 명 수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int[] studentGrade = new int[1000]; // 학생 점수 배열 선언
			int[] arr = new int[101]; // 누적 배열 선언
			int tcNum = sc.nextInt();// testCase 번호
			for (int i = 0; i < 1000; i++) {
				int grade = sc.nextInt(); // 점수 입력
				studentGrade[i] = grade;  // 학생 점수 배열 완성
				arr[grade] += 1;          // 등록과 동시에 arr 완성 (인덱스는 점수) , (값은 명)
			}
			int max = 0;
			int idx = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= arr[max]) {
					max = i;
				}
			}System.out.printf("#%s %s\n",tcNum,max );
		}
	}
}

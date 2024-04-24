package Day_2;

import java.util.Arrays;
import java.util.Scanner;

public class Manynum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int [] studentGrade = new int[1000]; //학생 점수 배열 선언
		int [] arr = new int[100]; // 누적 배열 선언
		int count = 0; //카운트 배열선언 
		for(int t = 0 ; t < tc ; t++){
			int tcNum = sc.nextInt();//testCase 번호
			for(int i = 0 ; i < 1000 ; i++ ) {
				int grade = sc.nextInt(); //점수 입력
				studentGrade[i] = grade; //학생 점수 배열 완성				
			}
			Arrays.sort(studentGrade);
			for(int i = 0 ; i < 1000; i++) {
				if(studentGrade[i] == studentGrade[i+1]) { //다음 숫자와 같으면 카운트
					count++;
				}else {
					arr[studentGrade[i-1]] = count; //studentGrade에 다른 값이 나오면 점수와 갯수 저장
					count = 0;  //다른 값이 나오면 카운트 초기화
				}
			}int max = 0;
			int idx = 0;
			for(int i = 0 ; i < 99 ; i++) {
				if(arr[i]<arr[i+1]) {
					max = arr[i+1];
					idx = i;
				}
			}
			System.out.printf("#%s %s",tcNum,idx );
		}
		
	}

}

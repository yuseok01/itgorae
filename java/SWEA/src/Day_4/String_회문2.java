package Day_4;

import java.util.Scanner;
/*
 * 1 행 회문 검사
 *    범위를 지정함으로 빈틈없이 검사
 *   1) 홀수 
 *   2) 짝수 
 * 2 열 회문 검사(for문 j, i 반전 사용할때는 그대로 arr[i][j] 
 * 	 1) 홀수
 * 	 2) 짝수
 */
public class String_회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			char[][] arr = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String input = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = input.charAt(j); // charAt으로 문자 배열로 받기 
				}
			}//행 회문 검사 시작 
			int rowMax = 0;
			int evenCnt = 0;
			int oddCnt = 0;
			//짝수 시작
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100-1; j++) {
					if (arr[i][j] == arr[i][j + 1]) {
						evenCnt = 2;
						int left = j - 1;
						int right = j + 2;
						while (left >= 0 && right < 100) { //경계 지정으로 빠짐없이 검사
							if (arr[i][left] == arr[i][right]) {
								evenCnt += 2;
								left--;
								right++;
							} else
								break; //회문아님! 다시 if문으로 
						}

					}
					rowMax = Math.max(evenCnt, rowMax);
					
					//홀수 시작
					if(j -1 >=0 && j+1 <100) { //한계지정 FALSE시 j+1
						if(arr[i][j-1]==arr[i][j+1]) //가운데 인놈 빼고 양쪽이 같으면 while문으로 진행
							oddCnt = 3;
						int left = j-2;
						int right = j+2;
						
						while(left >=0 && right < 100) { //한계지정 
							if(arr[i][left]== arr[i][right]) { //가운데 인놈 빼고 그다음 양쪽이 같으면 홀수 카운트 +2 계속반복
								oddCnt += 2;
								left--;
								right++;
								
							}else 
								break ;
						}
					}
				}
				rowMax = Math.max(oddCnt,rowMax);

			}//열 시작! 반복
			 int colMax = 0;
			 evenCnt = 0;
			 oddCnt =0;
			 
			 for (int j = 0; j<100; j++) {
				 for(int i = 0; i <100-1 ;i++) {
					 if(arr[i][j] == arr[i+1][j]) {
						 evenCnt = 2;
						 int left = i-1;
						 int right = i+2;
						 
						 while(left>=0 && right <100) {
							 if(arr[left][j] == arr[right][j]) {
								 evenCnt +=2;
								 left--;
								 right++;
								 
							 }else
								 break;
					
						 }
					 }
					 colMax = Math.max(evenCnt, colMax);
					 
					 if (i-1 >= 0 && i+1 <100) {
						 if(arr[i-1][j]==arr[i+1][j]) {
							 oddCnt=3;
							 int left = i -2;
							 int right = i +2;
							 while(left>= 0 && right < 100) {
								 if(arr[left][j]==arr[right][j]) {
									 oddCnt += 2;
									 left--;
									 right++;
								 }
								 else
									 break;
							 }
							 
						 }
					 }
					 colMax = Math.max(oddCnt, colMax);
				 }
			 }
			 System.out.printf("#%d ", tc);
			 System.out.println(Math.max(rowMax, colMax));
			

		}
	}

}

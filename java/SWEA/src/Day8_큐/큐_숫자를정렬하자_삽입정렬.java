package Day8_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

public class 큐_숫자를정렬하자_삽입정렬 {
	// 삽입정렬 새로운거 삽입할때 좋음
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); //인트로 입력받기

		for (int t = 1; t <= tc; t++) { //테케 진행
			int n = Integer.parseInt(br.readLine()); //인트로 입력받기 
			int [] arr= new int[n];
			
			
			String [] input = br.readLine().split("\\s+"); //문자열로 입력받기
			for (int i = 0; i < n; i++) { 
				arr[i] = Integer.parseInt(input[i]); //입력받은 문자열 int arr로 넣기 
			}
			insult(arr);	
			
			System.out.print("#"+t+" ");
			for(int i = 0 ; i< n ; i++) {
				System.out.print(arr[i]+" ");
				
			}
			System.out.println();
			
		}
		
		
	}
	static  void insult(int [] arr) {
		for(int i =1 ; i <arr.length; i++) {
			int key = arr[i]; //두번째를 키값 계속올라감
			int j = i-1;
			
			while ( j >= 0 && arr[j]>key) { //키값이랑 비교 j인덱스는 키값보다 항상 작음
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key; //키값이 초기 i 값임 
		}
		
	}
}

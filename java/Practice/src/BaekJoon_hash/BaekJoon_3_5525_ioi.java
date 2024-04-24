package BaekJoon_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_3_5525_ioi {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		0
		int n = Integer.parseInt(br.readLine()); //연속으로 나와야할 갯수
		int m = Integer.parseInt(br.readLine()); //char의 길이
		char arr[] = br.readLine().toCharArray(); //한줄을 char배열로 입력
		int cnt = 0;
		int result = 0;
		for(int i =1 ; i<m-1 ; i++) { // 1부터 m-1까지 
			if(arr[i-1]=='I' && arr[i]=='O' && arr[i+1] == 'I') { //문자열 비교하기 
				cnt++;
				
				if(cnt==n) { //연속해서 나왔으면
					cnt--;//결과 반영했으니 다시 감소 
					result++;
				}
				i++;
			}
			else { //연속해서 안나왔으면 다시 초기화
				cnt = 0;
			}
		}
		System.out.println(result);
	
	}
}

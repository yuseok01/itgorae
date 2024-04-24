package BeakJoon_순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {
	static int [] number; //숫자 저장 배열 갯수 n개
	static int [] calculate;
	static int n; 
	static int max;
	static int min;
	static int[] expression;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1 ; t<=tc ; t++) {
			n = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			number = new int[n];
			calculate = new int[4];
			expression = new int[n-1];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< 4; i++) {
				calculate[i]= Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i =0; i< n; i++) {
				number[i]=Integer.parseInt(st.nextToken());
			}
			check(0);
			
			int result = max - min;
			System.out.println("#"+ t + " "+result);
		}
	}
	static void check(int idx) {
		if(idx == n-1) { //idx 다 고려했어
			calcNum();
		}
		for(int i =0; i<4; i++) {
			if(calculate[i] == 0) {
				continue; //다썼어	
			}
			calculate[i]--; //하나 썼어
			expression[idx] = i; //쓴거 저장
			check(idx+1); //다음꺼 쓸꺼 저장
			calculate[i]++; //다썼으면 원상 복구 
		}
	}
	private static void calcNum() {
		int num = number[0];
		for(int i = 0 ; i<n-1;i++) {
			if(expression[i]==0) {
				num += number[i+1];
			}
			else if(expression[i]==1) {
				num-= number[i+1];
			}
			else if(expression[i]==2) {
				num*=number[i+1];
			}
			else if(expression[i]==3) {
				num /= number[i+1];
			}
		}
		if(num > max) {
			max = num;
		}
		if(num < min) {
			min = num;
		}
	}
}

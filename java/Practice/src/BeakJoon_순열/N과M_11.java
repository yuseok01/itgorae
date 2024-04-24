package BeakJoon_순열;

import java.util.*;
import java.io.*;

public class N과M_11 {
	
	static int N, M;
	static int[] arr, printArr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		printArr = new int[M];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(printArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before = -1; //이전 값을 중복하지 않기 위해서 
		for(int i=0; i<N; i++) {
			int now = arr[i]; //현재 값
			if(before != now) {
				before = now;
				printArr[depth] = arr[i]; //뎁스에 계속걸리는거지 m이 2면 2에 계속걸림  depth 1은 고정 
				dfs(depth + 1);
			}
				
		}
	}
}
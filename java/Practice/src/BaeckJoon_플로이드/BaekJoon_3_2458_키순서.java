package BaeckJoon_플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_3_2458_키순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean [][] check = new boolean[n+1][n+1];
		
		for(int i = 0 ; i< m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			check[a][b] = true; //직접연결한 애들 true 체크 
		}
		for(int k = 1; k <= n; k++) {
			for(int i =1; i<=n; i++) {
				for(int j = 1; j <= n; j++) {
					if(check[i][k] && check[k][j]) { //중간 경로 k를 거쳐 연결된 i j도 true로 저장 
						check[i][j]=true;
					}
				}
			}
		}
		int [] cnt = new int[n+1];
		for(int i = 1; i<= n; i++) {
			for(int j = 1; j <= n ; j++) {
				if(check[i][j] || check[j][i]) {
					cnt[i]++; 
				}//i에 연결된 애들 cnt 배열에 저장
			}
		}
		int res = 0;
		for(int i = 0 ; i < cnt.length ; i++) {
			if(cnt[i] == n-1) //cnt에 n-1만큼 카운트 되어있으면 모든 간선을 볼수 있는 노드니깐 result 값 올려주기 
				res++;
		}
		System.out.println(res);
	}
}

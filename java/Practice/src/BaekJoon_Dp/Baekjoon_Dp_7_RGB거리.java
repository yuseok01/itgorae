package BaekJoon_Dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Baekjoon_Dp_7_RGB거리 {
	
	static int[][] Cost;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //집갯수 
		Cost = new int[N][3]; //비용
		DP = new int[N][3]; //최소 비용 저장 배열 누적합 저장 
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) { //집수만큼 돌자
			
			st = new StringTokenizer(br.readLine()); 
			Cost[i][0] = Integer.parseInt(st.nextToken());
			Cost[i][1] = Integer.parseInt(st.nextToken());
			Cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
		DP[0][0] = Cost[0][0]; //레드 고를때
		DP[0][1] = Cost[0][1]; // 그린 고를때 
		DP[0][2] = Cost[0][2]; // 블루 고를때 
		
		//맨끝이 red로 끝날때 그린으로 끝날때 블루로 끝날때 
		System.out.println(Math.min(Cost(N- 1, 0), Math.min(Cost(N - 1, 1), Cost(N - 1, 2))));
	}//3가지 경우의 수에서 최소값 찾기 
	static int Cost(int N, 	int color) {
		if(DP[N][color] == 0) {
			if(color == 0) { //레드 고를때 
				DP[N][0] = Math.min(Cost(N - 1, 1), Cost(N - 1, 2)) + Cost[N][0];
			}
			else if(color == 1) {
				DP[N][1] = Math.min(Cost(N - 1, 0), Cost(N - 1, 2)) + Cost[N][1];
			}
			else {
				DP[N][2] = Math.min(Cost(N - 1, 0), Cost(N - 1, 1)) + Cost[N][2];
			}
			
		}
		
		return DP[N][color];
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_2_11404_플로이드 {
	/* 
	 * step1 출력 배열 최대값 초기화 max value 안됨
	 * step2 [i][j]열 최소값 초기화 (동일 노선 존재)
	 * step3 플로이드로 경유 하는 비용이 더 적으면 초기화 
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 정점 갯수
		int m = Integer.parseInt(br.readLine()); // 간선 갯수 
		int [][] arr = new int[n+1][n+1]; //0인 마을은 없음
		
		for(int i = 1 ; i<= n; i++) {
			for(int j = 1 ;j <= n ;j++) {
				arr[i][j] = 987654321;
				
				if(i==j) {
					arr[i][j] = 0;
				}
			}
		}
		
		for(int i = 0 ; i < m ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		for(int k = 1 ; k <= n ;k++) {
			for(int i = 1 ; i <= n ; i++) {
				for(int j = 1 ; j <= n ; j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		for(int i = 1 ; i <= n ;i++) {
			for(int j = 1 ; j <= n ; j++) {
				if(arr[i][j] == 987654321) {
					arr[i][j] = 0;
					
				}
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
}

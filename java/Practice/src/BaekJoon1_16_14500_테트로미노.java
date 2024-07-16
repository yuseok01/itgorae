import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_16_14500_테트로미노 {
	private static int n;
	private static int m;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int [] dx = {-1,1,0,0};
	private static int [] dy = {0,0,-1,1};
	private static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < m ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0; j < m ; j++) {
				visited[i][j] = true; //썻어
				solution(i,j,arr[i][j],1);
				visited[i][j] = false; //
			}
		}

		System.out.println(maxSum);
		
		
	}

	private static void solution(int x, int y, int sum, int depth) {
		if(depth == 4) { //테르로미노 완성
			maxSum = Math.max(sum, maxSum);
			return;
		}
		
		for(int k = 0 ; k < 4 ; k++) {
			int idx = x + dx[k];
			int idy = y + dy[k];
			
			if(0<= idx && idx < n && 0<= idy && idy < m && !visited[idx][idy]) {
				if(depth == 2) {
					visited[idx][idy] = true;
					solution(x,y,sum+arr[idx][idy], depth+1);
					visited[idx][idy] = false;
				}
				visited[idx][idy] = true;
				solution(idx, idy, sum+arr[idx][idy], depth + 1);
				visited[idx][idy] = false;
			}
		}
		
	}
}

package A형대비문제;

<<<<<<< HEAD
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범서비스 {
	private static int n;
	private static int price;
	private static int[][] arr;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1 ; t <= tc ; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			price = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			
			for(int i = 0 ; i < n ; i++) {
				result = 0;
				st=new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int k = 1 ; k <= n+1 ; k++) { //마름모 크기 최대크기는 n+1
				
				for(int i = 0 ; i < n ; i++) {
					for(int j = 0 ; j < n ; j++) {
						bfs(i, j, k); //현재 arr과 마름모의 크기 
					}
				}
			}
			System.out.println("#" + t + " " + result);
			
		}
	}

	private static void bfs(int i, int j, int k) {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];
		q.offer(new Point(i,j));
		
		int cnt = 0; 
		
		if(arr[i][j] == 1) {//집이면
			cnt++;
			visited[i][j]=true;
		}
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int d = 0 ; d < 4 ; d++) {
				int idx = now.x + dx[d];
				int idy = now.y + dy[d];
				
				if(0<= idx && idx < n && 0<= idy && idy < n ) {
					if(Math.abs(idx-i)+Math.abs(idy-j) < k && !visited[idx][idy]) {
						if(arr[idx][idy]==1) cnt++;
						
						q.offer(new Point(idx,idy));
						visited[idx][idy] = true;
						
					}
					
				}
			}
		}
		if(result < cnt) {  
			int nowK = k*k+(k-1)*(k-1);
			if((price*cnt-nowK)>= 0) {
				result = cnt;
			}
		}
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홈방범서비스 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/*
		 * 4중포문
		 */
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int[][] arr = new int[8][3];
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < y; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}int max = Integer.MIN_VALUE;
			for(int i = 0; i < x; i++) {
				for(int j = 0 ; j < y ;j++) {
					
					
					for(int dx = x-n ; dx <  )
				}
			}
		}
>>>>>>> origin/main
	}
}

package DDay17_im대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day2_6_유기농배추 {
	static int [][] arr ;
	static int cnt;
	static boolean [][] visited;
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	static int x;
	static int y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
			for(int tc = 0 ; tc < t ; tc++) {
				st= new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				arr = new int[x][y];
				visited = new boolean[x][y];
				for(int i = 0 ; i < x; i++) {
					for(int j = 0 ; j <y ; j++) {
						arr[i][j]=0;
					}
				}
				
				for(int i = 0 ; i <num ; i++) {
					st = new StringTokenizer(br.readLine());
						arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] =1;
					
				}
				cnt = 0;
				
				for(int i = 0 ; i < x; i++) {
					for(int j = 0 ; j <y ; j++) {
						if(arr[i][j]==1 && !visited[i][j]) {
						
							bfs(i,j);
							cnt++;
						}
					}
				}
				System.out.print(cnt);
			}

	}
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j }); // 큐에 i j 값 추가 
		ㄹ
		while(!q.isEmpty()){//큐가 비었다면 
			i = q.peek()[0];
			j = q.peek()[1];
			visited[i][j] = true; //방문 체크
			q.poll(); //방문했다면 큐에서 제거 
			for(int k =0; k<4;k++) { //4방향 탐색
				int idx = i + dx[k];
				int idy = j + dy[k];
					
				if(0<=idx && idx < x && 0<=idy && idy < y) { //경계설정
					if(!visited[idx][idy] && arr[idx][idy]==1) { 
						q.add(new int[] {idx,idy}); //새로운 인덱스 큐에 추가 
						visited[idx][idy]= true;
					}
				}
				
			}
			
		}
	}
}

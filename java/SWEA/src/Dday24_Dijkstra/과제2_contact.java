package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 가중치가 없는 그래프 문제 
 */
public class 과제2_contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10 ;
		
		for(int t = 1 ; t<=T ; t++) {
			st= new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); //노드 갯수
			int v = Integer.parseInt(st.nextToken()); //시작점
			
			int [][] adj= new int[101][101];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < m /2 ; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1; //단방향..
				
			}
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[101];
			q.offer(v);
			visited[v] = true;
			int max = 0;
			while(!q.isEmpty()) {
				System.out.println("큐사이즈는"+q.size());
				int cnt = q.size(); //같은 깊이에 있는 원소갯수
				max = 0; //마지막 큐에서 초기화할꺼라 괜찮음 
				while(cnt>0) {
					cnt--;
					int temp = q.poll();
					max = Math.max(max, temp);
					for(int i = 1; i<=100 ; i++) {
						if(!visited[i] && adj[temp][i]==1) {
							q.add(i);
							visited[i] = true;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, max);
			
		}
	}
}

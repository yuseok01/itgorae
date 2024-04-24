package BeakJoon_BFS넓이_BFS깊이;

import java.util.*;
import java.io.*;

public class BeackJoon_DFS와BFS {
	static int Edge[][];
	static boolean Visited[];
	static int N;
	static int M;
	static int V;
    static int count;
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		Edge = new int[N+1][N+1];
		Visited = new boolean[N+1];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 

			Edge[x][y] = Edge[y][x] = 1; //입력값 인덱스로 
		}

		DFS(V);
		System.out.println();

		Visited = new boolean[N+1];
		BFS(V);
	
	} 
	public static void BFS(int start) { 
		que.offer(start);	 
		Visited[start] = true;  //두번 처리되지 않게 전처리 
		System.out.print(start + " "); 

		while( !que.isEmpty() ) { 
			start = que.poll();

			for(int i=1; i<=N; i++) { 

				if(Edge[start][i] == 1 && Visited[i] == false) { 
					que.offer(i);
					Visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}	
	}
	public static void DFS(int start) {
		Visited[start] = true;
		System.out.print(start + " ");

        if(count == N) { //간선의 갯수만큼 출력되면 스탑 
			return;
		}
		count ++;

		for(int i=1; i<=N; i++) {
			if(Edge[start][i] == 1 && Visited[i] == false) {
				DFS(i);
			}
		}
	}
}
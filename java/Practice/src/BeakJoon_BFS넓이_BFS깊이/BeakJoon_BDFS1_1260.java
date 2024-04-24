package BeakJoon_BFS넓이_BFS깊이;

import java.util.*;
import java.io.*;

public class BeakJoon_BDFS1_1260 {
	static int Edge[][];
	static boolean Visited[];
	static int N;
	static int M;
	static int V;
    static int count;
	static Queue<Integer> que = new LinkedList<>();

	public static void BFS(int start) { //시작 할 정점 메서드로 입력 
		que.offer(start);	 //시작 정점 큐에 넣기 
		Visited[start] = true;  //큐에 들어가면 방문 체크 
		System.out.print(start + " "); //출력 

		while( !que.isEmpty() ) { //큐가 빌때까지
			start = que.poll();

			for(int i=1; i<=N; i++) { //N 정점의 개수 

				if(Edge[start][i] == 1 && Visited[i] == false) { //방문하지 않았고 
					que.offer(i);
					Visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}	
	}

	public static void DFS(int start) {//시작 할 정점 메서드로 입력 
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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		Edge = new int[1001][1001];
		Visited = new boolean[1001];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //왼쪽
			int y = Integer.parseInt(st.nextToken()); //오른쪽 

			Edge[x][y] = Edge[y][x] = 1; //정점 값을 인덱스로 
		}

		DFS(V);
		System.out.println();

		Visited = new boolean[1001];
		BFS(V);
	
	} 
}
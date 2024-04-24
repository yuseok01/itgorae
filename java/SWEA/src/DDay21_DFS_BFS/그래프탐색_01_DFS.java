package DDay21_DFS_BFS;
import java.util.Arrays;
import java.util.Scanner;

public class 그래프탐색_01_DFS {
	static int V; // 정점의 수
	static int[][] adj; // 인접행렬
	static boolean[] visited; // 방문쳌

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		int E = sc.nextInt();

		adj = new int[V + 1][V + 1]; // 시작정점이 1번부터 시작!
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A][B] = adj[B][A] = 1; //인접행렬 (무향)
		} //간선 정보 입력 완료
		
		DFS(1);

	}
	
	public static void DFS(int v) {
		//v 방문처리
		visited[v] = true;
		System.out.println(v);
		
		//인접한 친구들 방문 (인접행렬, 인접리스트 코드가 쬐끔 달라)
		for(int i = 1; i<=V; i++) {
			if(!visited[i] && adj[v][i] == 1)
				DFS(i);
		}
		
		//인접 리스트를 썼을 때는 아래처럼 사용도 가능(예시)
//		for(int w : adj[v]) {
//			if(!visited[w]) {
//				DFS(w)
//			}
//		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7\r\n" + "";
}

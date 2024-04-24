package DDay21_DFS_BFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색_02_BFS {
	static int V; // 정점의 수
	static List<Integer>[] adj;
	static boolean[] visited; // 방문쳌

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		int E = sc.nextInt();
		adj = new ArrayList[V+1];
		for(int i = 1; i<=V; i++)
			adj[i] = new ArrayList<>(); //초기화 완료
		visited = new boolean[V + 1];

		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A].add(B);
			adj[B].add(A); //무향이니까
		} //간선 정보 입력 완료
		
		BFS(1);
		

	}
	//v : 시작정점
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v); //시작정점을 큐에 넣는다. 
		visited[v] = true; //시작정점 박문철2한다.
		
		
		//큐가 공백상태가 될때까지 반복문 수행
		while(!queue.isEmpty()) {
			int curr = queue.poll(); //정점 하나를 꺼내!
			System.out.println(curr); //경로 한번 찍어보기 
			
			//인접리스트!
			for(int w:adj[curr]) {
				if(!visited[w]) {
					queue.add(w);
					visited[w] = true; //미리 박문철3를 해서 중복으로 큐에 넣는것 방지
				}
			}
		}
	}
	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7\r\n" + "";
}

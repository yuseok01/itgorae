package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 노선으로 다익스트라 
 * 시작점과 끝점이 정해져있음 
 * 최단거리 저장할 배열이 필요해 
 * 부모 필요없음 
 * 인접 행렬 값 무한대로 
 */
public class BaekJoon_4_1753_최단경로 {
	static int V;
	static int E;
	static int start;

	static class Node implements Comparable<Node>{
		int v;
		int w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static public void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[V + 1];
		int[] result = new int[V + 1]; //
		List<Node>[] adj = new ArrayList[V+1];

		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();// 사용 선언해야함
			result[i] = Integer.MAX_VALUE;// infnity 값
		}

		for (int i = 1; i <= E; i++) {

			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, w));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>(); // 노드타입이어야해
		result[start] = 0; //시작점 0으로 시작 
		q.add(new Node(start, 0)); //시작점 가중치 0으로 시작
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(!visited[now.v]) { //들어온 곳이 방문하지 않은 곳이면
				visited[now.v] = true;
			}
			for(int i = 0 ; i < adj[now.v].size() ; i++) { //연결되어 있는 곳만큼만
				Node next = adj[now.v].get(i);
				
				if(!visited[next.v] && now.w + next.w < result[next.v]) {
					result[next.v] = now.w + next.w; //가중치 갱신
					
					q.add(new Node(next.v, result[next.v])); //다음 노드 , 가중치 갱신
				}
				
			}
		}
		for(int i = 1 ; i <= V ; i++) {
			if(result[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(result[i]);
		}
	}
}

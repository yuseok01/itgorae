package BaekJoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2_1389_케빈베이컨 {
	private static int[] visited;
	private static ArrayList<Integer>[] list;
	private static int V;
	private static int E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visited = new int[V+1]; 
		list = new ArrayList[V+1];
		for(int i = 0 ; i < V+1 ; i++) {
			list[i] =new ArrayList<>();
		}
		
		for(int i = 1 ; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		sol();
		
	}

	private static void sol() {
		int minCnt = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i = 1 ; i<= V; i++) { //i부터 V까지 탐색
			int cnt = BFS(i);
			if(minCnt > cnt) {
				minCnt = cnt;
				minIdx = i;
			}
		}
		System.out.println(minIdx);
	}

	private static int BFS(int start) {
		//i를 from to from to ....

		Arrays.fill(visited, -1);
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(start); // 당연히 i부터 탐색
		visited[start] = 0;
		
		while(!q.isEmpty()) {
			int from = q.poll();
			for(int to : list[from]) {
				if(visited[to] != -1) {
					continue; //갈곳이 방문한 곳이라면
				}
				visited[to] = visited[from]+1; //방문쳌
				cnt += visited[to];
				q.add(to); //to를 from으로 
			}
		}
		return cnt;
	}
	
}

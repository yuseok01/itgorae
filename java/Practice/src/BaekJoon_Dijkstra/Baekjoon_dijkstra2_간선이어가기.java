package BaekJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_dijkstra2_간선이어가기 {
	static class Node implements Comparable<Node>{
		int to, w;
	public Node(int to, int w) {
		this.to = to;
		this.w = w;
		
	}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
			
		}
	}
	private static ArrayList<Node>[] adjlist;
	private static int v;
	private static int e;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		adjlist = new ArrayList[v+1];
		for(int i = 0 ;i <= v ; i++) {
			adjlist[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < e ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjlist[a].add(new Node(b,c));
			adjlist[b].add(new Node(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		//찾아야할 간선
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		int ans = dijkstra(start, goal);
		
		System.out.println(ans);
		
	}
	private static int dijkstra(int start, int goal) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean checked[] = new boolean[v+1];
		int cost[] = new int[v+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		Arrays.fill(checked, false);
		
		cost[start] = 0;
		pq.add(new Node(start,0));
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(checked[now.to]) continue;
			checked[now.to] = true;
			
			for (Node next : adjlist[now.to]) {
				if(cost[next.to] > next.w + now.w) {
					cost[next.to] = next.w + now.w;
					pq.add(new Node(next.to, cost[next.to]));
				}
			}
		}
		
		return cost[goal];
	}
	
}

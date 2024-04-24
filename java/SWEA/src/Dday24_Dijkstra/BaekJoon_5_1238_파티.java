package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_5_1238_파티 {
	static class Node implements Comparable<Node> {
		int to;
		int w;

		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int V;
	static int E;
	static int goal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());

		List<Node>[] adj = new ArrayList[V + 1];
		List<Node>[] reverseAdj = new ArrayList[V + 1];

		// step1
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[from].add(new Node(to, w));
			reverseAdj[to].add(new Node(from, w));
		}
		int[] dist1 = dij(adj);
		int[] dist2 = dij(reverseAdj);

	}

	private static int[] dij(List<Node>[] adj) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(goal,0));
		
		boolean[] check = new boolean[V+1];
		int [] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[goal] = 0;
		
		while(!pq.isEmpty()) {
			Node nowNode = pq.poll();
			int now = nowNode.to;
			
			if(!check[now]) {
				check[now] = true;
				
				for(Node node : a.get(now)) {
					if(!check[town.end] && dist[town.end] )
				}
			}
		}
		return null;
	}

}

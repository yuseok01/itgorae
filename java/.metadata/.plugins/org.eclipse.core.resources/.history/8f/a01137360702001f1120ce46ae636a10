package BaekJoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_4_1707_이분그래프 {
	static List<Integer>[] list;
	static boolean [] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc ; t++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			visited = new boolean[V+1];
			for(int i = 0 ; i <= V ; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0 ; i < E ; i++) {
				st=new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
				list[to].add(from);
			}
			Queue<Integer> q = new LinkedList<>();
			for(int i = 1 ; i <=V ; i++) {
				if(!visited[i]) {
					q.add(i);
					
					visited[i] = ture;
				}
				while(!q.isEmpty()) {
					int now = q.poll();
					
				}
			}
		}
	}
	
	

}

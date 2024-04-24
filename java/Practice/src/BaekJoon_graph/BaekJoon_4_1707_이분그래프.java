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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc ; t++) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[] visited = new int[V+1];
			list = new ArrayList[V+1];
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
				if(visited[i]==0) {
					visited[i] = 1;
				
					for(int j = 0; j<list[i].size();i++) {
						int now = list[i].get(j); //i랑 붙어있는애 
						int tmp = visited[i]; // 이전 색 비교하기 위해 
						if(visited[now]==0) {
							if(tmp == 1) {
								visited[now] = 2;
								
							}
							else if(tmp == 2) {
								visited[now] = 1;
							}
						}else if(visited[now]==1 && now != tmp) {
							visited[now] == 
						}
						
					}
					
				
				}
			}
		}
	}
	
	

}

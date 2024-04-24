package Dday22_그래프비용탐색;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 과제_SWEA_하나로_프림 {
	public static class Node implements Comparable<Node>{
		int no;
		long w;
		
		public Node(int no, long w) {
			this.no = no;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <=T; tc++) {
			
			//섬갯수
			int N = Integer.parseInt(br.readLine());
			Point[] land = new Point[N]; 
			boolean[] visited = new boolean[N];
			
			st= new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				land[i] = new Point(0,0); //2차원 배열 좌표들어올땐 point 활용
				land[i].x = Integer.parseInt(st.nextToken());
			}
			
			st= new StringTokenizer(br.readLine());
			for(int i =0; i<N; i++) 
				land[i].y = Integer.parseInt(st.nextToken());
			
			
			double E = Double.parseDouble(br.readLine());
			
			ArrayList<Node>[] adj = new ArrayList[N]; //간선 저장
			for(int i =0; i<N ; i++) {
				adj[i] = new ArrayList<>();
				
				//가중치 구하기
				for(int j =0; j<N;j++) {
					if(i == j) continue;
					long distX = Math.abs(land[i].x - land[j].x);
					long distY = Math.abs(land[i].y - land[j].y);
					adj[i].add(new Node(j,distX*distX + distY*distY));
				}
			}
			long sum = 0;
			int nodeCnt = 0;
			PriorityQueue<Node> q = new PriorityQueue<>();
			q.add(new Node(0,0));
			
			while(!q.isEmpty()) {
				Node now = q.poll();
				//이미 확인한 노드는 pass
				if(visited[now.no]) continue;
				
				sum += now.w;
				visited[now.no] = true;
				//모든 노드 확인 완료
				if(++nodeCnt == N) break;
				
				for(int i =0; i< adj[now.no].size();i++) {
					Node next = adj[now.no].get(i);
					if(!visited[next.no]) {
						q.add(next);
					}
				}
			}
			System.out.println("#"+ tc + " "+Math.round(sum*E));
			
			
		}
		
			
	}
	
	

}

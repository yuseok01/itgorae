package BaekJoon_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 단방향이네 
 * maxValue이라는 것은 방문하지 않았다는 것 == 연결되어있지않다.
 * maxValue가 아닌 값 중 가장 큰 값이 마지막에 방문한 간선이다.
 * 
 */
public class Baekjoon_dijkstra3_해킹 {
	static class Node implements Comparable<Node>{
		int to;
		int t;
		public Node(int to, int t) {
	
			this.to = to;
			this.t = t;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.t - o.t;
		}
		
	}

	static ArrayList<Node>[] list;
	private static int[] time;
	private static boolean[] visted;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for ( int t = 1 ; t <= tc ; t++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken()); //정점수
			int e = Integer.parseInt(st.nextToken()); //간선수
			int start = Integer.parseInt(st.nextToken()); //감염시작된 컴퓨터 
			list = new ArrayList[v+1]; 
			time = new int[v+1]; //time 누적할 배열 
			visted = new boolean[v+1];
			for(int i = 0 ; i < v+1 ; i++) {
				time[i] = Integer.MAX_VALUE;
				list[i] = new ArrayList<>();
			}
			for(int i = 0 ; i < e ; i++) {
				st = new StringTokenizer(br.readLine());
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list[from].add(new Node(to,time));
			}
			int infectedTime = 0 ;
			int infectedCom = 0;
			
			dijkstra(start);
			
			for(int i = 1 ; i < v +1 ;i++) {
				if(time[i] != Integer.MAX_VALUE) {
					infectedCom++;
					infectedTime = Math.max(infectedTime, time[i]);
				}
			}
			System.out.println(infectedCom+ " " + infectedTime);
			
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		time[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int now = pq.poll().to;
			//행선지
			if(!visted[now]) {
				visted[now] = true;
				for(Node next : list[now]) {
					if(time[next.to] > time[now] + next.t) {
						time[next.to] = time[now] + next.t;
						pq.add(new Node(next.to, time[next.to]));
						//다음 갈 곳은 next 노드가 가지고 있는 to 와 dist가 가지고있는 다음 갈 곳의 시간
					}
				}
			}
		}
		
	}
}

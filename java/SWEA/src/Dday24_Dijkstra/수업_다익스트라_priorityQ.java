package Dday24_Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * step1 출발지도 하나의 경유지 처럼
 */


public class 수업_다익스트라_priorityQ {
	static class Node{
		int vertex,weight; // 정점의 번호와 가중치
		Node next; //다음 포인트
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점갯수 
		int E = Integer.parseInt(st.nextToken()); //간선 갯수 
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		final int INF = Integer.MAX_VALUE;
		
		Node [] adjList = new Node[V]; //인접 배열 저장할 것
		int[] minDistance = new int[V]; // 최소 거리 저장할 것
		boolean[] visited = new boolean[V]; //방문처리할 것 
		
		for(int i = 0 ; i <E; i++) { //간선 갯수만큼 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]); //??????
		}
		Arrays.fill(minDistance, INF);
		minDistance[start] = 0; //출발지에서 출발지로의 비용 0 초기화
		
		
		int min = 0; 
		int stopOver = 0;
		for(int i = 0 ; i < V ;i++) { //모든 정점이 다 처리될때까지 반복
			//step1 : 미방문 정점 중 출발지에서 가장 가까운 정점
			
			min = INF;
			stopOver = -1;
			
			for(int j = 0 ; j < V ; j++) {
				if(!visited[j] && min > minDistance[j]) { //미방문 정점 중에 가장 최소의 정점찾기
					min = minDistance[j];
					stopOver = j; //경유지 정점으로 기록
				}
			}
			if(stopOver == -1) break; //만약 못찾으면....
			visited[stopOver] = true;
//			if(stopOver == end) break; //도착점이면 끝내기 굳이 다볼필요없엉
			
			// step2 : 미방문 정점들에 대해 선택된 경유지를 거쳐서 가는 비용과 기존 최소비용을 비교해서 업데이트
			for(Node temp = adjList[stopOver]; temp != null; temp = temp.next) {
				if(visited[temp.vertex] && minDistance[temp.vertex] > min+ temp.weight) {
					minDistance[temp.vertex] = min +temp.weight;
				}
			}
			
		}
		System.out.println(Arrays.toString(minDistance)); //못가는애들은 inf로 되어있음 갈수있으면 비용 
		System.out.println(minDistance[end] != INF ? minDistance[end] : -1);
		
	}
}

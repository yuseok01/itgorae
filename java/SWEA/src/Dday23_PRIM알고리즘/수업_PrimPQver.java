package Dday23_PRIM알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class 수업_PrimPQver {
	static class Vertex implements Comparable<Vertex>{
		int no,weight;
		/*
		 * ## 프림 알고리즘으로 만든 최소신장트리

탐욕적인 방법으로 다음 노드를 선택 

선택되지않은 노드의 간선의 가장 적은 값을 추가해 트리를 완성해감
		 */
		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight,  o.weight);  //간선의 가중치 기준으로 오름차순 
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[V][V]; // 인접 행렬
		boolean[] visited = new boolean[V]; // 트리정점여부
		int[] minEdge = new int[V]; // 비트리정점 기준으로 트리정점과 연결했을 경우 최소 간선비용

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken()); //최소값을 저장할 배열 
			}								
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 계속 갱신을 위한 최대값 초기화
		minEdge[0] = 0; // 임의의 시작점 0을 위해 처리 더미
		pq.offer(new Vertex(0, minEdge[0])); //시작점 
		
		int result = 0;
		int c = 0;// main의 지역변수
		while (!pq.isEmpty()) { //v번돌면안되지 
			// step1 : 비트리 정점 중 최소 간선 비용의 정점 찾기
			Vertex minVertex = pq.poll();
			if(visited[minVertex.no]) continue;
			result += minVertex.weight; // 간선 비용 누적
			visited[minVertex.no] = true; // 트리 정점에 포함
			if(++c ==V) break; // 트리정점에 올라가있는 갯수 카운트
			// step2 : 새롭게 트리의 정점에 확장된 정점 기준으로 비트리 정점들과의
			// 간선비용 고려해서 최적 없데이트
			for (int i = 0; i < V; i++) {
				if (!visited[i] && adjMatrix[minVertex.no][i] != 0
						&& adjMatrix[minVertex.no][i] < minEdge[i]) { // 비트리면서 인접해있어하며 더 작아야함 																									
					minEdge[i] = adjMatrix[minVertex.no][i]; //최소값 갱신 priorityQ 변경 가능성이있다.
					pq.offer(new Vertex(i,minEdge[i]));
				}
			}
		}
		System.out.println(c==V?result:-1); //이걸 위해 c 를 main 변수로 변경한거임
	}

}
//5
//0 5 10 8 7
//5 0 5 3 6
//10 5 0 1 3
//8 3 1 0 1
//7 6 3 1 0
//-> 10


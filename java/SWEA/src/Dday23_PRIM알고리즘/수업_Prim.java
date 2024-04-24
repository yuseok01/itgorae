package Dday23_PRIM알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수업_Prim {
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
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 계속 갱신을 위한 최대값 초기화
		minEdge[0] = 0; // 임의의 시작점 0을 위해 처리 더미
		int result = 0;
		int c;// main의 지역변수
		for (c = 0; c < V; c++) {
			// step1 : 비트리 정점 중 최소 간선 비용의 정점 찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && minEdge[i] < min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			if (minVertex == -1)
				break;
			result += min; // 간선 비용 누적
			visited[minVertex] = true; // 트리 정점에 포함

			// step2 : 새롭게 트리의 정점에 확장된 정점 기준으로 비트리 정점들과의
			// 간선비용 고려해서 최적 없데이트
			for (int i = 0; i < V; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0
						&& adjMatrix[minVertex][i] < minEdge[i]) { // 비트리면서 인접해있어하며 더 작아야함 																									
					minEdge[i] = adjMatrix[minVertex][i]; //최소값 갱신 priorityQ 변경 가능성이있다.
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


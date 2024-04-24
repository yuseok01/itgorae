package Dday22_그래프비용탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 과제_SWEA_MST_240327_최소신장트리 {
	static class Edge implements Comparable<Edge> { // 객체들과 비교가 가능
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) { // 생성자
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	static Edge[] edgeList; // 정점 배열
	static int[] parents; // 부모 저장배열
	static int V, E;

	public static void make() { // 처음 자기자신 호출
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	public static int find(int a) { // 대장 찾고
		if (parents[a] == a) // 자기가 대장이면 자기 리턴
			return a;
		return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) { // 대장이 같으면 유니온하자~
		int aRoot = find(a);// a 대장 찾고 초기화
		int bRoot = find(b);// b 대장 찾고 초기화
		if (aRoot == bRoot)
			return false; // 둘이 대장 같으면 돌아가 너희 이미 같은회사야

		// 두 노드의 root가 다르면 합침
		parents[aRoot] = bRoot; // 대장끼리 연결 level을 짧게하자!
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()) + 1;
			E = Integer.parseInt(st.nextToken());
			parents = new int[V]; // 노드갯수
			edgeList = new Edge[E]; // 간선갯수

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(from, to, weight);// 리스트에 객체저장하자
			} // 간선 저장
			make(); // 하나씩 만들어보아라

			Arrays.sort(edgeList); // 정렬 기준이?
			int result = 0; // 결과 초기화
			int count = 0; // 연결 간선수
			for (Edge edge : edgeList) {

				if (union(edge.start, edge.end)) {// true면 대장끼리 연결완료
					result += edge.weight; // 결과에 가중치 저장
					count++;
				}
				if (count == V - 1) { // 종료지점 이거 중요 간선수 = 정점 -1
					break;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}

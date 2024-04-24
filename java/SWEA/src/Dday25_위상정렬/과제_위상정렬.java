package Dday25_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 과제_위상정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int[] degree = new int[V + 1];

			List<Integer>[] graph = new ArrayList[V + 1];

			for (int i = 0; i <= V; i++) { // 노드 채우기
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b); //a에 b를 연결 
				degree[b]++; // 진입 차수 증가
			}
			Queue<Integer> queue = new ArrayDeque<>();

			// 큐로 위상정렬 구현 1단계
			// 진입 차수 0인 정점들을 넣어
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0)
					queue.offer(i);
			}
			StringBuilder sb = new StringBuilder();

			// 큐로 위상정렬 구현 2단계
			// 큐가 공백상태가 될때까지 돌린다.
			while (!queue.isEmpty()) {
				int now = queue.poll();
				sb.append(now).append(" "); // 0인놈들 출력
				for (int i = 0; i < graph[now].size(); i++) {
					int num = graph[now].get(i);
					degree[num]--;
					if (degree[num] == 0)
						queue.add(num);
				}
			}
			System.out.println("#" + t + " " + sb);
		}

	}

}

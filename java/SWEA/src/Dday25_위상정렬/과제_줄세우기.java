package Dday25_위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 과제_줄세우기 {
	/*
	 * 필요한 변수 
	 * 1.degree 변수
	 * 2.a와 b 담을 변수 그래프로하든 2차원배열로하든 point로 하든   
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] degree = new int[V + 1];
		List<Integer>[] graph = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			degree[b]++; // 진입 차수 증가
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= V; i++) {
			if (degree[i] == 0)
				q.offer(i);
		}
		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			for (int i = 0; i < graph[now].size(); i++) { // now에 붙어있는 갯수 
				int num = graph[now].get(i);
				degree[num]--;
				if (degree[num] == 0)
					q.add(num);
			}
		}
		System.out.println(sb);
	}
}

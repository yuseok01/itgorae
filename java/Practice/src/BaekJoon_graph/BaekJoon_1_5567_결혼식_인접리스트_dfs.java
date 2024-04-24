package BaekJoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
 * 간선으로 들어오는 문제를
 * 인접리스트를 활용하여
 * dfs로 해결
 */
public class BaekJoon_1_5567_결혼식_인접리스트_dfs {
	static int V;
	static int E;
	static boolean[] check;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		List<Integer> list[] = new ArrayList[V + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		check = new boolean[V + 1];
		check[1] = true;
		dfs(1, list, 0); // 상근이는 1이니깐
		for (int i = 2; i < check.length; i++) { //0과 상근이는 친구에 포함되지 않아
			if (check[i])
				cnt++;
		}
		System.out.println(cnt);

	}

	private static void dfs(int num, List<Integer>[] list, int depth) {
		if (depth == 2) {
			return; // 친구의 친구까지
		}
		for (int i = 0; i < list[num].size(); i++) { // for문이 넓게 퍼지는 장치
			int to = list[num].get(i); // num에 붙어있는 i번째 친구
			check[to] = true;
			dfs(to, list, depth + 1); // to가 from으로 깊이 +1
		}

	}
}

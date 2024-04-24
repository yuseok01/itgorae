package BaekJoon_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 간선으로 들어오는 문제를
 * 인접행렬를 활용하여
 * 2중 포문으로 해결
 */
public class BaekJoon_1_5567_결혼식_인접행렬_dfs2 {
	static int[][] map;
	static int[] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		map = new int[V + 1][V + 1];
		dist = new int[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map[from][to] = map[to][from] = 1;
		}
		for (int i = 2; i <= V ; i++) {
			if (map[1][i] == 0) { // 1이랑 접점 없으면 다음으로
				continue;
			} else {
				dist[i] = 1; // 접점있으면 상근이랑 i와 연결 저장
			}
			for (int j = 2; j <= V; j++) {
				if (map[i][j] == 1) { // i랑 연결된애들 저장
					dist[i] = dist[j] = 1;
				}
			}
		}
		int result = 0;
		for (int i = 1; i <= V; i++) {
			result += dist[i];
		}
//		System.out.println(dist[1]);
		System.out.println(result);

	}

}

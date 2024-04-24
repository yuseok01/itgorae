package 월말대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class tree1 {
	static int N; // 노드 수
	static int[] parent;
	static boolean[] isVisit;
	static StringTokenizer st;
	static ArrayList<Integer> list[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 전위순회
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		isVisit = new boolean[N + 1];
		list = new ArrayList[N + 1];
		parent = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>(); // 각리스트 어레이리스트로 사용

		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
			// 각 부모 자식 연결
		}
		dfs(1);

		for (int i = 2; i < parent.length; i++) { // 0과 1 제외
			System.out.println(parent[i]);

		}

	}

	static void dfs(int index) {
		isVisit[index] = true;
		for (int i : list[index]) { // list idx와 연결되어 있는 값꺼내서 i에 저장
			if (!isVisit[i]) { // i가 방문 안했다면
				parent[i] = index; // i인덱스에 index 저장 index는 부모 노드
				dfs(i);
			}
		}

	}
}

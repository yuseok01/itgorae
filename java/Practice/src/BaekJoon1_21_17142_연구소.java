import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1_21_17142_연구소 {
	private static int n;
	private static int m;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int minSec;
	private static List<virusLocation> list;
	private static int empty;

	static class virusLocation {
		int x;
		int y;

		public virusLocation(int x, int y) {

			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];
		list = new LinkedList<>();
		empty = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new virusLocation(i, j));
				} else if (arr[i][j] == 0) {
					empty++;
				}
			}
		}
		minSec = Integer.MAX_VALUE;
		boolean[] visited = new boolean[list.size()];
		selectActive(0, list, visited, arr);

	}

	private static void selectActive(int activeCnt, List<virusLocation> list, boolean[] visited, int[][] arr) {
		if (activeCnt == m) { // m개 활성화했어 퍼트려

			int cnt = 0; // 바이러스 퍼진 횟수
			int sec = 0;
			Queue<virusLocation> q = new LinkedList<>();

			for (int i = 0; i < list.size(); i++) {
				if (visited[i]) { // i 바이러스 활성화
					q.add(list.get(i));
				}
			}
			while (cnt == empty) { // 바이러스가 퍼진 횟수 == 빈 곳과 같아 질때 까지
				virusLocation now = q.poll();
				for (int k = 0; k < 4; k++) {
					int idx = now.x + dx[k];
					int idy = now.y + dy[k];
					if (0 <= idx && idx < n && 0 <= idy && idy < n && arr[idx][idy] == 0) {
						arr[idx][idy] = 2;
						cnt++; // 바이러스 퍼트렸어
						q.add(new virusLocation(idx, idy));
					}
				}
				sec++;
			}
			minSec = Math.min(minSec, sec);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				selectActive(activeCnt + 1, list, visited, arr);
				visited[i] = false;
			}
		}

	}
}

package BaekJoon_hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon_4_4195_친구네트워크 {
	static int[] parent, count;

	static int find(int a) {
		if (a == parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA > rootB) { // a부모가 더 크면 a 부모
			int temp = rootA;
			rootA = rootB;
			rootB = temp;
		}
		if (rootA == rootB) // 부모가 같으면 실패
			return false;
		parent[rootB] = rootA; // 아니면 연결
		count[rootA] += count[rootB]; // 친구 네트워크도 늘리자
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			HashMap<String, Integer> hash = new HashMap<>();

			int n = Integer.parseInt(br.readLine());
			int idx = 0;
			int[][] friend = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String friend1 = st.nextToken();
				String friend2 = st.nextToken();
				if (!hash.containsKey(friend1)) {
					hash.put(friend1, idx++);
				}
				if (!hash.containsKey(friend2)) {
					hash.put(friend2, idx++);
				}
				friend[i] = new int[] { hash.get(friend1), hash.get(friend2) };

			}
			parent = new int[idx];
			for(int i = 0; i< idx; i++) {
				parent[i] = i;
			}
			count = new int[idx];
			Arrays.fill(count, 1);
			for (int[] f : friend) {
				union(f[0], f[1]);
				System.out.println(count[find(f[0])]);
			}

		}

	}
}

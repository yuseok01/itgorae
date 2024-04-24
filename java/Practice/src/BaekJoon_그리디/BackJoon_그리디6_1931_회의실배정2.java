package BaekJoon_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BackJoon_그리디6_1931_회의실배정2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

//		que.add(new int[] {1, 9});
//		que.add(new int[] {2, 3});
//		que.add(new int[] {3, 5});
//		que.add(new int[] {2, 4});
//		System.out.println(Arrays.toString(que.poll()));
//		System.out.println(Arrays.toString(que.poll()));
//		System.out.println(Arrays.toString(que.poll()));
//		System.out.println(Arrays.toString(que.poll()));

		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] S, int[] E) {
				if (S[1] == E[1]) {
					return S[0] - E[0];
				}
				return S[1] - E[1];
			}
		});
		int cnt = 0;
		int end = -1; //??
		for(int i = 0; i < n ; i++) {
			if(arr[i][0] >= end) {
				end = arr[i][1];
				cnt ++;
			}
		}
		System.out.println(cnt);
	}
}

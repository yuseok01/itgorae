package BeakJoon_정렬;

import java.io.*;
import java.util.*;

public class Sort_선긋기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int result = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			arr[i][0] = p1;
			arr[i][1] = p2;
		}
		Arrays.sort(arr, new Comparator<int[]>() { // 정렬 기준 재설정
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		int min = arr[0][0]; // 이전 선의 좌표 초기화
		int max = arr[0][1];
		int len = max - min;
		for (int i = 1; i < n; i++) {
			if (min <= arr[i][0] && arr[i][1] <= max) {
				// 이전선 내부에 현재 선이 들어갈때 카운트 x
				continue;
			} else if (arr[i][0] < max) {
				len += arr[i][1] - max;
			} else { // 현재선과 겹치지 않는다면 새로 카운트
				len += arr[i][1] - arr[i][0];
			}
			min = arr[i][0];
			max = arr[i][1];
		}
		System.out.println(len);
	}
}

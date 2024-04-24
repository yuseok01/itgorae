package BaekJoon_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BeakJoon_3_이분탐색_1477_휴게소세우기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());// n개의 휴개소
		int m = Integer.parseInt(st.nextToken());// m개 더새울꺼임
		int l = Integer.parseInt(st.nextToken()); // 최대 위치
		List<Integer> list = new ArrayList<>();

		list.add(0); // 0도 넣어야지!
		list.add(l); // 끝도 넣어야지
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);

		// 이분탐색
		int left = 1; // 첫점 1
		int right = l; // 끝점 l

		while (left <= right) {
			int mid = (left + right) / 2; // mid길이에 지을꺼양~
			int count = 0;
			for (int i = 1; i < list.size(); i++) { // 노드 사이즈 만큼
				count += (list.get(i) - list.get(i - 1) - 1) / mid;

			}
			if (count > m)
				left = mid + 1; //
			else
				right = mid - 1;
		}
		System.out.println(left);
	}
}

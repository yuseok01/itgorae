package BaekJoon_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BackJoon_그리디6_1931_회의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<int[]> que = new PriorityQueue<>((arr1, arr2)->arr1[1]-arr2[1]);

//		que.add(new int[] {1, 9});
//		que.add(new int[] {2, 3});
//		que.add(new int[] {3, 5});
//		que.add(new int[] {2, 4});
//		System.out.println(Arrays.toString(que.poll()));
//		System.out.println(Arrays.toString(que.poll()));
//		System.out.println(Arrays.toString(que.poll()));
//		System.out.println(Arrays.toString(que.poll()));
		
		
		int n = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			que.add(new int[] {a,b});
		}
		int cnt = 0;
		
		int min = Integer.MIN_VALUE;
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			int a = arr[0];
			int b = arr[1];
			if(a-b == 0) {
				continue;
			}
			
			if(a >= min) {
				cnt++;
				min = b;
			}
			
		}
		System.out.println(cnt);
		
	}
}

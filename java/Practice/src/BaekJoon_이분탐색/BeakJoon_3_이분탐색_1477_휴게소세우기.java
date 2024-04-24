package BaekJoon_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BeakJoon_3_이분탐색_1477_휴게소세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());//n개의 휴개소
		int m = Integer.parseInt(st.nextToken());// m개 더새울꺼임
		int totalHiway = Integer.parseInt(st.nextToken()); // 고속도로의 길이
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int [] rest = new int[n+2];
		rest[0] =0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i < n+1 ; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
			if(i==n) {
				rest[n+1]=totalHiway-1;
			}
		}
		Arrays.sort(rest);
		for(int i= 1; i< rest.length ; i++) {
			pq.add(rest[i]-rest[i-1]);
		}
		for(int i = 0; i<m ; i++) {
			if(pq.peek() % 2 ==0) {
				int tmp = pq.poll()/2;
				pq.add(tmp);
				pq.add(tmp);
			}
			else {
				int tmp = pq.poll()/2;
				pq.add(tmp);
				pq.add(tmp+1);
			}
		}
		System.out.println(pq.peek());
		
	}
}

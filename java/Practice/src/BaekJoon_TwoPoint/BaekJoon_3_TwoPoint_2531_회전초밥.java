package BaekJoon_TwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoon_3_TwoPoint_2531_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 접시수
		int d = Integer.parseInt(st.nextToken()); // 가지수
		int k = Integer.parseInt(st.nextToken()); // k번 연속해서
		int c = Integer.parseInt(st.nextToken()); // 쿠폰
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0 ; i < n ; i++) {
			st=new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			q.add(tmp);
		}
		int result = Integer.MIN_VALUE;
		
		for(int l = 0 ;l<n ; l++) {
			Set<Integer>  sushi = new HashSet<>();
			for(int i = 0 ; i<k; i++) {
				if(sushi.contains(q.peek())){
					q.add(q.poll());
				}
				else {
					int tmp = q.poll();
					sushi.add(tmp);
					q.add(tmp);
				}
				
			}if(sushi.contains(c)) {
				result = Math.max(sushi.size(), result);
			}
			else {
				result =  Math.max(sushi.size()+1, result);
			}
		}
		System.out.println(result);
	}
}

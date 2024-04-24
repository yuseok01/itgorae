package Day8_큐;

import java.util.*;
import java.io.*;

/*
 * ver (queue)
 * 손님오는 시간 오름차순 정렬
 * 
 * 만드는 배열 i+1 & 2 마다 붕어빵만듬 
 * stock += 만드는 갯수 
 * arr[q.peek()-1] =
 * 
 */

public class 큐_진기의붕어빵3 {
	static int[] customer;
	static int stock; // 붕 재고
	static int N, M, K;
	static String isStock;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 손님 수 문자열을 정수로
			M = Integer.parseInt(st.nextToken()); // 붕어빵 만드는 시간
			K = Integer.parseInt(st.nextToken()); // 한 번에 만들어지는 붕어빵 갯수

			customer = new int[N];
			stock = 0;
			q = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < customer.length; i++) {
				customer[i] = Integer.parseInt(st.nextToken()); // 손님 오는 시간 배열받기
			}
			Arrays.sort(customer); // 손님온 시간 정렬
			for (int i = 0; i < N; i++) {
				q.offer(customer[i]);
			}
			isStock = "Possible";

			check(tc, q); // 1번 테스트 케이스일때 메서드 값 리턴
		}
	}

	public static void check(int t, Queue<Integer> q) {
		
		
		start: for (int i = 1; i <=customer[N-1]; i++) { // 마지막 손님올때까지
			
			if (i % M == 0 ) { //M초마다 k개 만들기
				stock += K;
			}
			if(q.isEmpty() && q.peek()== i) {
				isStock = "Impossible";
				break start;
			}
			while (!q.isEmpty() && q.peek() == i) { // 손님이 오면
				if (stock > 0) { //재고가 있으면
					stock--;
					q.poll();
				}
				else { //재고가 없으면 종료 
					isStock = "Impossible";
					break start;
				}	
			}

		}
		if (q.isEmpty()) {
			isStock = "Possible";
		}
		System.out.println("#" + t + " " + isStock);
	}
}
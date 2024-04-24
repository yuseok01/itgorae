package BeakJoon_큐덱우선순위큐;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BeakJoon_0203_2075Lv3_우선순위큐_정답 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(); //우선순위 큐 선언
//한글자씩 받을라면 스트링
		for (int i = 0; i < N * N; i++) {
			int num = sc.nextInt();

			// 우선순위 큐에 값 추가
			pq.offer(num);

			// 큐의 크기가 N을 초과하면 가장 작은 값 제거
			if (pq.size() > N) {
				pq.poll();
			}
		}

		// 큐에서 가장 작은 값이 N번째로 큰 수
		System.out.println(pq.poll());
	}
}
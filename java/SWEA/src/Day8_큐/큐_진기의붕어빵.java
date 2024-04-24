package Day8_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐_진기의붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> stock = new LinkedList<>();
		int tc = sc.nextInt(); // tc 개수
		for (int t = 1; t <= tc; t++) {

			int N = sc.nextInt(); // 몇명오는지
			int M = sc.nextInt(); // 만드는데 걸리는 초
			int k = sc.nextInt(); // 몇개 만드는지
			String isPossible = null;
			int[] arrive = new int[N];
			int[] arrivetimeIdx = new int[11112];
			int [] maketimeIdx = new int [11112];
			int sum = 0;
			for (int i = 0; i < N; i++) { // arrive = 손님이 몇 초 뒤에 오는지
				arrive[i] = sc.nextInt();
				arrivetimeIdx[arrive[i]] += 1; //해당 시간(Idx)에 몇개의 붕어빵이 나가는지 
			}
			for(int i = 0 ; i <= 11111; i++) {
				if(i%M == 0) {
					sum += k;
				}
				sum -= arrivetimeIdx[i];
			}
			
			System.out.print("#" + t + " " + isPossible);
			System.out.println();

		}
}

}

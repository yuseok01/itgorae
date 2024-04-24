package Day8_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class pizzaData { // 피자 데이터와 "치즈의 숫자를" 저장하는 곳
	int pizzaNum;
	int ci;

	public pizzaData(int pizzaNum, int ci) {

		this.pizzaNum = pizzaNum;
		this.ci = ci;
	}

}

public class 큐_피자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<pizzaData> Pizza = new LinkedList<>();
		Queue<pizzaData> fire = new LinkedList<>();

		// testcase 개수
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			// N 화덕의 크기
			int N = sc.nextInt();
			// M 치즈의 양
			int M = sc.nextInt();

			
			for (int i = 1; i < M+1; i++) { // 피자갯수와 치즈양을 피자 데이터에 추가
				pizzaData pd = new pizzaData(i, sc.nextInt()); // 피자데이터타입의 pd선언 피자인덱스와 치즈양이 저장됨
				Pizza.offer(pd);
			}
			List<Integer> perfectpizza = new ArrayList<>(); // 완벽한 피자

			for (int i = 0; i < N; i++) { // 치즈 양만큼 회전
				fire.offer(Pizza.poll()); // 화덕에 화덕에 양만큼 추가
				
			}
			

			while (!fire.isEmpty()) {

				while (fire.peek().ci / 2 > 0) {

					fire.peek().ci /= 2; //
					fire.offer(fire.poll()); // 1이 아니라면 다시 넣고 나눠주는 행위
				}
				perfectpizza.add(fire.peek().pizzaNum);
				fire.poll();

				if (!Pizza.isEmpty()) {
					fire.offer(Pizza.poll());

				}

			}
			System.out.println("#" + t + " "+perfectpizza.get(M-1));
		}
	}
}

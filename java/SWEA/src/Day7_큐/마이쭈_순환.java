package Day7_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
	String name;
	int cnt;

	Person(String name, int cnt) {
		this.name = name;
		this.cnt = cnt;
	}
}

public class 마이쭈_순환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Person> queue = new LinkedList<>();

		int N = 20;
		int pNum = 1;

		queue.offer(new Person(sc.next(), 1)); //최초에 넣음

		while (N > 0) { // 사탕수가 있을때까지 
			if (!queue.isEmpty()) { //큐가 비어있지않으면 
				Person P = queue.poll();
				N -= P.cnt;
				if (N <= 0) {
					System.out.println(P.name + "님이 마지막 마이쭈를 먹습니다."); //Person p = new Person();

				} else {
					System.out.println(P.name + "님이" + P.cnt + "만큼 가져갔습니다.");
					P.cnt++;
					System.out.println("남은 마이쮸 "+ N +"개");
					queue.offer(P);
					queue.offer(new Person(sc.next(),1));
				}
			}
		}

	}

}

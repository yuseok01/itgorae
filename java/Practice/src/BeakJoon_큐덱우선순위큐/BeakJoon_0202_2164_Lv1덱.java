package BeakJoon_큐덱우선순위큐;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BeakJoon_0202_2164_Lv1덱 {
    public static void main(String[] args) {
    	//입력받기
        Scanner scanner = new Scanner(System.in);
        //카드입력
        int N = scanner.nextInt();
        
        //카드라는 변수의 정수 덱 생성
        Deque<Integer> cards = new ArrayDeque<>();

        // N개까지 카드를 큐에 넣기
        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }

        //최초 큐 size N개 1개남을때까지 반복 
        while (cards.size() > 1) {
            // 첫번째 넣은 카드 버리기 (첫번째 넣은 카드가 맨위에 있다)
            cards.poll();

            // 그다음 카드 터트리고 다시 추가 반복
            if (!cards.isEmpty()) {
                int topCard = cards.poll();
                cards.add(topCard);
            }
        }

        // 마지막에 남은 카드 출력
        System.out.println(cards.peek());
    }
}



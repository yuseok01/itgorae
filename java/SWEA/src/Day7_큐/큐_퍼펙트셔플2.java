package Day7_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 큐_퍼펙트셔플2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스의 수

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt(); // 카드의 수
            scanner.nextLine(); // 개행 문자 처리

            String[] cards = scanner.nextLine().split(" "); // 카드 이름 배열

            // 퍼펙트 셔플 수행
            shuffleWithQueue(cards);

            // 결과 출력
            System.out.print("#" + t + " ");
            for (String card : cards) {
                System.out.print(card + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // 큐를 사용한 퍼펙트 셔플 메소드
    private static void shuffleWithQueue(String[] cards) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        int mid = (cards.length + 1) / 2;

        // 큐에 카드 나눠서 넣기
        for (int i = 0; i < mid; i++) {
            queue1.offer(cards[i]);
        }
        for (int i = mid; i < cards.length; i++) {
            queue2.offer(cards[i]);
        }

        // 큐에서 교대로 빼면서 덱 재구성
        int index = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            cards[index++] = queue1.poll();
            cards[index++] = queue2.poll();
        }

        // 만약 N이 홀수인 경우 마지막에 남은 카드 추가
        while (!queue2.isEmpty()) {
            cards[index++] = queue2.poll();
        }
    }
}
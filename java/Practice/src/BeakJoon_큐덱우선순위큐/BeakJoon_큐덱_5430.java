package BeakJoon_큐덱우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BeakJoon_큐덱_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열의 길이
            String arrStr = br.readLine().replaceAll("[\\[\\],]", ""); // 배열 문자열에서 괄호 및 쉼표 제거
            String[] arrStrArr = arrStr.split(" "); // 배열을 문자열 배열로 변환

            Deque<Integer> deque = new LinkedList<>();
            boolean isReverse = false; // 뒤집혔는지 여부

            for (String numStr : arrStrArr) {
                deque.add(Integer.parseInt(numStr));
            }

            boolean isError = false;

            for (char op : p.toCharArray()) {
                if (op == 'R') {
                    isReverse = !isReverse; // R 연산은 뒤집기
                } else if (op == 'D') {
                    if (deque.isEmpty()) {
                        isError = true; // D 연산 시 덱이 비어있으면 에러
                        break;
                    }

                    if (isReverse) {
                        deque.pollLast(); // 뒤집혔을 때는 뒤에서 제거
                    } else {
                        deque.pollFirst(); // 뒤집히지 않았을 때는 앞에서 제거
                    }
                }
            }

//            if (isError) {
//                System.out.println("error");
//            } else {
//                printResult(deque, isReverse);
//            }
//        }
//    }

//    private static void printResult(Deque<Integer> deque, boolean isReverse) {
//        StringBuilder result = new StringBuilder("[");
//        while (!deque.isEmpty()) {
//            int num = isReverse ? deque.pollLast() : deque.pollFirst();
//            result.append(num);
//            if (!deque.isEmpty()) {
//                result.append(",");
//            }
//        }
//        result.append("]");
//        System.out.println(result);
//    }
            }
        }
}
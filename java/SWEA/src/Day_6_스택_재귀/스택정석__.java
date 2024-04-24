package Day_6_스택_재귀;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class 스택정석__ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 소비

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" "); //공백을 기준으로 나누어 배열에 저장

            switch (input[0]) {
                case "1":
                    stack.push(Integer.parseInt(input[1])); 
                    break;
                case "2":
                    results.add(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "3":
                    results.add(stack.size());
                    break;
                case "4":
                    results.add(stack.isEmpty() ? 1 : 0);
                    break;
                case "5":
                    results.add(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }

        for (int result : results) { //출력값을 array리스트에 저장 
            System.out.println(result);
        }
    }
}

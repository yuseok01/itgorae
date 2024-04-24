package Day_5;
import java.util.Scanner;
import java.util.Stack;

public class Swea_쇠막대자르기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int tc = 1; tc <= 10; tc++) {
            int length = Integer.parseInt(scanner.nextLine()); //문자열 길이 받기 
            String input = scanner.nextLine(); //문자열 받기 

            Stack<Character> stack = new Stack<>(); //스택 선언 
            int result = 1; 

            for (int i = 0; i < length; i++) {
                char c = input.charAt(i);  //현재 문자열 초기화

                if ("({[<".contains(String.valueOf(c))) { //현재 문자열이 여는 문자열에 포함되어있다면 스택에 추가 
                    stack.push(c);
                } else if (")]}>".contains(String.valueOf(c))) { //현재 문자열이 닫는 문자열에 포함되어있다면 추가
                    if (stack.isEmpty() || stack.pop() != getMatchingBracket(c)) { //현재 문자열이 닫는 문자열인데 스택이 비어있거나 스택 탑이 현재 문자열과 페어를 이루지 않는다면 
                        result = 0;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                result = 0;
            }

            System.out.println("#" + tc + " " + result);
        }

        scanner.close();
    }

    private static char getMatchingBracket(char bracket) {
        if (bracket == ')') {
            return '(';
        } else if (bracket == ']') {
            return '[';
        } else if (bracket == '}') {
            return '{';
        } else if (bracket == '>') {
            return '<';
        } else {
            return '\0'; // Invalid case
        }
    }
}
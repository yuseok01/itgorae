package Day_6_스택_재귀;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택정석_string_버퍼버전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼라인 선언

        int N = Integer.parseInt(br.readLine()); //N 입력받기 
        Stack<Integer> stack = new Stack<>();  //정수 스택선언

        StringBuilder result = new StringBuilder(); //결과 스티링빌더 선언 = 내맘대로 문자열 바꾸기 가능

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" "); //버퍼리더 한줄씩 읽고 공백받기 

            switch (input[0]) {
                case "push":
                    stack.push(Integer.parseInt(input[1])); //input[1] 정수로 변환하여 사용 
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        result.append(stack.pop()).append("\n"); // append = stringbuilder메서드 result에 추가 
                    } else {
                        result.append("-1\n"); 
                    }
                    break;
                case "size":
                    result.append(stack.size()).append("\n"); 
                    break;
                case "empty":
                    result.append(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        result.append(stack.peek()).append("\n");
                    } else {
                        result.append("-1\n");
                    }
                    break;
            }
        }

        System.out.println(result);
    }
}
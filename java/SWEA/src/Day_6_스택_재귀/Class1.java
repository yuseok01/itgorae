package Day_6_스택_재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Class1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in); 

		for (int tc = 1; tc <= 10; tc++) { //테스트케이스 시작
			Map<Character, Integer> priority = new HashMap<>();
			
			priority.put('+', 1);
			priority.put('-', 1);
			priority.put('*', 2);
			priority.put('/', 2);
			priority.put('(', 0);

			
			
			int t = Integer.parseInt(br.readLine());
			String expression = br.readLine();

			String postfix = "";
			Stack<Character> op = new Stack<>();

			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);

				if (c == '(') {
					op.push(c);
				} else if (c == ')') {
					while (op.peek() != '(') {
						postfix += op.pop();
					}
					op.pop();
				} else if ('0' <= c && c <= '9') {
					postfix += c;

				} else {
					if (op.isEmpty()) {
						op.push(c);

					} else {
						// 우선순위가 낮은 연산자가 마지막에 위치할때 까지 pop
						while (!op.isEmpty() && priority.get(c) <= priority.get(op.peek())) {
							postfix += op.pop();

						}
						op.push(c);
					}
				}

			}System.out.println("#" + tc +" "+cul(postfix));
			
		}
		
	}

	public static int cul(String postfix) {
		Stack<Integer> calcul = new Stack<>(); // int로 변경

		for (int i = 0; i < postfix.length(); i++) {
			char now = postfix.charAt(i);

			if ('0' <= now && now <= '9') {
				calcul.push(now - '0'); // 수정: char를 int로 변환

			} else { // 연산자 처리 추가
				int A = calcul.pop();
				int B = calcul.pop();
				int result = 0;

				if (now == '-') {
					result = B - A;
				} else if (now == '+') {
					result = B + A;
				} else if (now == '*') {
					result = B * A;
				} else if (now == '/') {
					result = B / A;
				}

				calcul.push(result);
			}
		}

		return calcul.pop();
	}
}

package Day_6_스택_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BeakJoon_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼라인 선언
		int N = Integer.parseInt(br.readLine()); // N 입력받기 readLine은 한줄씩 읽어오기 
		StringBuilder result = new StringBuilder(); // 스트링 빌더 선언
		

		for (int tc = 0; tc < N; tc++) {
			char[] input = br.readLine().toCharArray();
			
			Stack<Character> st = new Stack<>(); // 스택선언
			
			
			for (int i = 0; i < input.length; i++) { // N 만큼 반복
				if (input[i] == '(') {
					st.push(input[i]);
				} else if (!st.isEmpty() && st.peek() == '(') {
					st.pop();

				}else {
					st.push(input[i]);
				}
			}
			if (st.isEmpty()) {
				result.append("YES\n");
			}else {
				result.append("NO\n");
			}
			
		

		}
		System.out.print(result);
	}

}

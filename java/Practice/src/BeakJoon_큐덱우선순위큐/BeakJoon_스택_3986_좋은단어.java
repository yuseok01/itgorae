package BeakJoon_큐덱우선순위큐; // 읽어드리는법과 스택의 용도를 익히자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BeakJoon_스택_3986_좋은단어 {
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		count = 0;
		for (int i = 0 ; i <t ; i++	) {
			String ab = br.readLine();
			goodWord(ab);
			
		}
	System.out.println(count);
		
	}
	static void goodWord(String ab) {
		Stack<Character> st = new Stack<>();
		if(ab.length() %2 == 1) return;
		st.push(ab.charAt(0)); //첫단어 푸시 
		for(int i = 1 ; i< ab.length();i++) {
			if(st.size()>0 && st.peek()==ab.charAt(i)) {
				st.pop();
			}
			else {
				st.push(ab.charAt(i));
			}
		}
		if(st.isEmpty()) count++;
	}
}

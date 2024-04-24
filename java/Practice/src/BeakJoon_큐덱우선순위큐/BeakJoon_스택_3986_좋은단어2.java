package BeakJoon_큐덱우선순위큐; // 스택은 짝을 찾을때 쓰기 좋다! 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BeakJoon_스택_3986_좋은단어2 {
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //인풋스트림 구현체 사용
		
		int tc = Integer.parseInt(br.readLine()); //br을 인수 형태로 변환
		for(int t = 0; t <tc ; t++){
			count=0;
			String ab = br.readLine();//기본적으로 br은 스트링
			A(ab);
			
		}System.out.println(count);
	
	}
	public static void A(String ab) {
		Stack<Character> st = new Stack<>(); 
		if(ab.length()%2 == 1) return;
		st.push(ab.charAt(0));
		for(int i = 0 ; i <ab.length();i++) {

			if(st.size()>0 && st.peek()==ab.charAt(i)) {
				st.pop();
			}else {
				st.push(ab.charAt(i));
			}
			
		}if(st.isEmpty()) count++;
		
	}
}

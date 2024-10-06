import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;

        
        //integer를 담는 Stack 선언
        Stack<Integer> st = new Stack<Integer>();
        
        // 전달받은 배열만큼 반복문을 돌면서
        for(int i=0; i<arr.length; i++){
        
        	// 우선, 배열 첫 번째 숫자를 stack에 삽입
            if(i==0) st.push(arr[i]);
           	// 인덱스 1부터는, stack의 최상단의 값(peek)이 arr[i]의 값과 일치여부 확인 후
            // 일치하지 않을 경우에만 stack에 해당 값 push
            else if(st.peek() !=arr[i]) st.push(arr[i]);
    
        }
        
      	// 결과값 answer의 사이즈는 stack의 사이즈와 동일하게 생성
        answer = new int[st.size()];
		// **stack의 사이즈만큼 반복문을 돌면서 
        // stack에서 꺼낸 값 pop하여 차곡차곡 담되,
        // stack에서 꺼내는 값은 LIFO로 실제 배열의 역순이므로
        // 역순으로 담는다 (i는 st.size()-1부터 시작, -1씩 줄여가며 i가 0보다 클때까지)
        for(int i=st.size()-1; i >= 0;i--){
            answer[i] = st.pop();
        }
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
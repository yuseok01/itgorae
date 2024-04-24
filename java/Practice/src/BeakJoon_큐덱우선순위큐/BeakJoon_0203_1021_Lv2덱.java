package BeakJoon_큐덱우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BeakJoon_0203_1021_Lv2덱 {
	public static void main(String[] args) throws IOException { 

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼 리더 사용 선언 
		
		LinkedList<Integer> deque = new LinkedList<Integer>(); //덱 링크드리스트 선언
		
		int count = 0;	// 2, 3번 연산 횟수 누적 합 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");  //공백을 두고 입력받기 
		int N = Integer.parseInt(st.nextToken());	// 큐의 크기
		int M = Integer.parseInt(st.nextToken());	// 뽑으려는 숫자의 개수 
		
		// 1부터 N까지 덱에 담아둔다.
		for(int i = 1; i <= N; i++) {
			deque.offer(i); //덱에 넣기 
		}
		
		int[] arr = new int[M];	// 뽑고자 하는 수를 담은 배열 
		
		st = new StringTokenizer(br.readLine(), " "); //공백으로 구분된 문자열을 나누고 정수로 변환하여 배열 arr에 저장
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); //
		}
		
		
		for(int i = 0; i < M; i++) {
			// 덱에서 뽑고자 하는 숫자의 위치(index) 찾기 
			int target_idx = deque.indexOf(arr[i]); //타겟하는 입력값을 덱의 인덱스 값으로 반환
			int half_idx; 
			
			
			if(deque.size() % 2 == 0) {
				half_idx = deque.size() / 2 - 1;
			}
			else {
				half_idx = deque.size() / 2;
			}
			
			
			
			if(target_idx <= half_idx) {  
				for(int j = 0; j < target_idx; j++) {
					int temp = deque.pollFirst();//앞에 제거
					deque.offerLast(temp); // 뒤에추가 
					count++;
				}
			}
			else {				
				for(int j = 0; j < deque.size() - target_idx; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			
			}
			deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
		}
		
		System.out.println(count);
		
		
	}
}

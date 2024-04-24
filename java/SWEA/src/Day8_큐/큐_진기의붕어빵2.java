package Day8_큐;

import java.util.*;
import java.io.*;

/*
 * 1.손님수 배열(i-1은 판매량 // i의 값은 오는 시간 )
 * 		1손님 1붕어빵 법칙 => i가 0부터 시작할때 i-1은 나간 붕어빵수
 * 
 * 2.재고
 * 		손님 오는 시간 * 붕어빵 생산량(단위 붕어빵개수 / 단위 시간) = 손님오는 시간에 생산된 붕어빵량
 * 
 * 
 * 
 * 
 * for문 -> 재고 - i시간에 필요한 생산량 >= 0 성공
 */


public class 큐_진기의붕어빵2 {
	static int[] customer; //손님 수 
	static int stock; //붕 재고  
	static int N, M, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 손님 수 문자열을 정수로 
			M = Integer.parseInt(st.nextToken()); // 붕어빵 만드는 시간
			K = Integer.parseInt(st.nextToken()); // 한 번에 만들어지는 붕어빵 갯수
			
			customer = new int[N]; 
			stock = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<customer.length; i++) {
				customer[i] = Integer.parseInt(st.nextToken()); //손님 오는 시간 배열받기
			}
			Arrays.sort(customer); //손님온 시간 정렬 
			
			check(tc); //1번 테스트 케이스일때 메서드 값 리턴
		}
	}
	public static void check(int t) {
		
		for(int i=0; i<customer.length; i++) {
			stock = (customer[i] / M) * K; // 손님이 온 시간이 됐을 때 붕어빵 몇개 만들어졌는지
			if(stock-i-1 < 0 ) { // i시간에 손님이 필요한 량보다 적으면 실패
				System.out.println("#"+t+" Impossible");
				return;
			}
		}
		System.out.println("#"+t+" Possible");
	}
}
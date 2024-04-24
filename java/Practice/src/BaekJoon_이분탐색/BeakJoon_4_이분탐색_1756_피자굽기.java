package BaekJoon_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BeakJoon_4_이분탐색_1756_피자굽기 {
	private static int D;
	private static int N;
	private static int[] fire;
	private static int pizza;
	private static int start;
	private static int end;
	private static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		fire = new int[D + 1]; // 더미를 위함 
		fire[0] = Integer.MAX_VALUE; //더미 장착 
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= D; i++) {
			fire[i] = Integer.parseInt(st.nextToken());
			fire[i] = Math.min(fire[i], fire[i - 1]);// 아래에 큰게 있는게 의미가 없음 
			//젤큰값 , 5,  5,  4,  3,  3,  2,  2 //층수에는 아무런 영향이 없음 
		}
		
		
	
		result = D;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pizza = Integer.parseInt(st.nextToken());
			start =0 ; //화로의 depth
			end = result;
			while(start <= end) {
				int mid = (start + end) /2;
				if(pizza <= fire[mid]) {
					start = mid +1 ; //합격 ~ ->> 더깊게 들어갈 수 있는지 보자
					result = mid;
				}
				else {
					end = mid -1; //불합격 -> 화덕 위쪽에 확인해보자 
				}
			}
		}
		System.out.println(result);
	}
}

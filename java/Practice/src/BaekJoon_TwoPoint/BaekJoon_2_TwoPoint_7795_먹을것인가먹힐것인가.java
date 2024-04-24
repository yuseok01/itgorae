package BaekJoon_TwoPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2_TwoPoint_7795_먹을것인가먹힐것인가 {
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int aSize = Integer.parseInt(st.nextToken());  // A 수
			int bSize = Integer.parseInt(st.nextToken());  // B 수
			
			int[] A = new int[aSize];
			int[] B = new int[bSize];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B.length; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			// 정렬
			Arrays.sort(A);
			Arrays.sort(B);
			
			// 투포인터
			int i = 0;  // A 인덱스 //앞쪽에서 투포인트 
			int j = 0;  // B 인덱스
			int cnt = 0;  // 큰 쌍의 개수
			while (true) {
				if (i == aSize || j == bSize) break;
				if (A[i] > B[j]) {
					cnt += aSize - i;//남은 a배열은 안봐도 같으니깐 남은 a 배열만큼 증가 
					j++;
				} else {
					i++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}

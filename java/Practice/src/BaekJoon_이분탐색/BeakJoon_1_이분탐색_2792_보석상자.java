package BaekJoon_이분탐색;

import java.io.*;
import java.util.*;

public class BeakJoon_1_이분탐색_2792_보석상자 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewels = new int[M];
        long result = 0;
/*
 * 최소 질투심 = 1  최대 질투심 = max
 * max+1 / 2 만큼 나누어 준다고 생각하고 점차 줄여나가보기 
 */
        for(int i = 0; i<M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
        }
		
        // 보석 개수 순으로 정렬
        Arrays.sort(jewels);
		
        // 이분 탐색
        long left = 1;
        long right = jewels[M-1];

        while(left <= right) { 
            int count = 0;
            long mid = (left + right) / 2; 
			
            // 이분 탐색을 통해 특정한 개수만큼 보석 나누어주기
            for(int i = M-1; i>=0; i--) {	 // 많은 보석수 역순으로 
            	// 보석의 개수가 특정한 개수로 나누어 떨어질 때
                if(jewels[i] % mid == 0) count += jewels[i] / mid; // mid개씩 나누어 준다고 가정했을때 몇명 필요한지
                // 보석의 개수가 특정한 개수로 나누어 떨어지지 않아 다른 1명에게 추가로 분배해야 할 때
                else count += jewels[i] / mid + 1; //딱떨어지지않으면 한사람더 필요함 
            }
			
            // 계속해서 질투심을 최소화 하기
            if(count <= N){ //필요한 사람 수가 주어진 사람수보다 적을 경우 왼쪽으로 
                result = mid;
                right = mid - 1;
            } else {//필요한 사람 수가 주어진 사람수보다 많을 경우 오른쪽으로 
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
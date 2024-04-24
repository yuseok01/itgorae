package BeakJoon_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 정렬된 배열 탐색
 */
public class BeakJoon_1재귀_큰수구성하기 {
    private static int N, k, res, cnt = 0, now = 0; 
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼리더 선언
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백으로 받기

        N = Integer.parseInt(st.nextToken()); //숫자 받기
        k = Integer.parseInt(st.nextToken()); //숫자받기 
        arr = new int[k]; 

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        findBig(0);
        System.out.println(res);
    }

    private static void findBig(int now) {
        // 기저 조건: 현재 값이 N보다 크면 중단
        if (N < now) return; //종료값 

        // 최댓값 갱신
        if (res < now) res = now;

        // 재귀 호출
        for (int i = 0; i < k; i++) {
            findBig((now * 10) + arr[i]);
        }
    }
}

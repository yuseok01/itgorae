package BaekJoon_이분탐색;
import java.io.*;
import java.util.*;

public class BeakJoon_4_이분탐색_1756_피자굽기2 {
    static int D, N, pos;
    static int[] oven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        oven = new int[D + 1]; //오븐 크게 받기 
        st = new StringTokenizer(br.readLine());
        oven[0] = Integer.MAX_VALUE; //오븐 앞에 최대값 
        for (int i = 1; i < D + 1; i++) {
            oven[i] = Integer.parseInt(st.nextToken()); 
            oven[i] = Math.min(oven[i - 1], oven[i]); // 아래에 큰게 있는게 의미가 없음 
          //젤큰값 , 5,  5,  4,  3,  3,  2,  2 //층수에는 아무런 영향이 없음 
        }

        st = new StringTokenizer(br.readLine());
        pos = D + 1; //포지션 변수 
        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(st.nextToken()); //피자 변수 
            binaryPizza(size, 0, pos - 1);
        }

        System.out.println(pos);
    }

    private static void binaryPizza(int size, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (size <= oven[mid]) { //size는 현재 사이즈  
                start = mid + 1; //합격 ~ ->> 더깊게 들어갈 수 있는지 보자
                pos = mid; // 메서드에서 다시 호출하면서 end값을 막아버림
            } else {
                end = mid - 1;//불합격 -> 화덕 위쪽에 확인해보자 
            }
        }
    }
}

package 발표;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class 수영장_1완탐 {
 
    static int[] cost, plan;
    static int result;
    /*
     * 생각해볼 것
     * 두 개의 1차원 배열일 때 
     * 재귀 탈출 조건을 설정 할 수있을 때 
     * 이문제에서는 최대 깊이가 12개로 설정 할 수있었음 
     */
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
 
            cost = new int[4]; 
            plan = new int[13]; //요금제
            // 가격 정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            // 계획 정보
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
            //기저 조건 최대 금액  
            result = cost[3]; 
             
            process(1, 0);
             
            System.out.println("#" + tc + " " + result);
        }
 
    }
 
    private static void process(int month, int sum) {//int at  int depth
        //탈출 조건 두 개 
        if(result <= sum) return;
         
        if(month > 12) {
            result = Math.min(result, sum);
            return;
        }
         
 
        if(plan[month] == 0) {
            process(month + 1, sum);
        } else {
            // 1일 이용권을 이용할 경유
            process(month + 1, sum + cost[0] * plan[month]);
             
            // 1달 이용권을 이용할 경우
            process(month + 1, sum + cost[1]);
             
            // 3달 이용권을 이용할 경우
            process(month + 3, sum + cost[2]);
        }
    }
 
}
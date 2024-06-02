import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_2_2056_작업 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] time = new int[n + 1]; // 각 작업의 소요 시간
        int[] dp = new int[n + 1]; // 각 작업의 완료 시간
        List<List<Integer>> adj = new ArrayList<>(); // 인접 리스트
        
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int pre = Integer.parseInt(st.nextToken());
                adj.get(pre).add(i);
            }
        }

        // DP 배열 초기화 및 작업 완료 시간 계산
        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) { // 아직 계산되지 않은 경우에만
                calculateCompletionTime(i, time, dp, adj);
            }
        }

        // 결과 계산: 모든 작업이 완료되는 데 걸리는 최소 시간
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        
        System.out.println(answer);
    }

    private static int calculateCompletionTime(int task, int[] time, int[] dp, List<List<Integer>> adj) {
        if (dp[task] != 0) {
            return dp[task];
        }//기저조건 dp[0]은 계산되어있음 
        
        int maxTime = 0;
        for (int preTask : adj.get(task)) { //[작업에 선행으로 수행되어야하는 값을 계산 둘중에 가장 많은 시간이 걸리는 것만 필요
            maxTime = Math.max(maxTime, calculateCompletionTime(preTask, time, dp, adj));
        }
        
        dp[task] = maxTime + time[task];
        return dp[task];
    }
}

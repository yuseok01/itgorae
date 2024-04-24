package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class BeakJoon_2_N_Queen {
    static int N, cnt, chess[];
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <=t; tc++ ) {
        	 N = Integer.parseInt(br.readLine());
             chess = new int[N];
      
             dfs(0);
             System.out.println("#" + tc + " "+cnt);
        	
        }
	   
    }
 
    private static void dfs(int now) {
        if (now == N) {
            cnt++;
            return;
        }
 
        for (int i = 0; i < N; i++) {
            chess[now] = i;
            if (check(now)) {
                dfs(now + 1);
            }
        }
    }
 
    private static boolean check(int col) {
        for (int i = 0; i < col; i++) {
           
            if (chess[col] == chess[i])
                return false;
            
 
            // 같은 대각선에 존재하는 경우
            if (col - i == Math.abs(chess[col] - chess[i]))
                return false;
        }
 
        return true;
    }
}
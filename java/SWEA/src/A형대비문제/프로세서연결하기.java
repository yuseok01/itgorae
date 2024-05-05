package A형대비문제;

import java.io.*;
import java.util.*;
 
public class 프로세서연결하기 {
    static int N;
    static int count;
    static int core[][];
    static int map[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int max_power;
    static int max_line = Integer.MAX_VALUE;
    static void dfs(int cnt, int connect, int line) {
        if(cnt == count) {
            if(connect > max_power) {max_power = connect; max_line = line;}
            else if(connect == max_power && max_line > line) {max_line = line;}
            return;
        }
         
        int x =core[cnt][0]; int y = core[cnt][1];
        f: for(int d = 0; d<4; d++) {
            for(int k=1; k<N; k++) {
                int nx = x+k*dx[d];
                int ny = y+k*dy[d];
                if(nx<0 || ny<0 || nx>=N || ny>= N) { // 끝에 도달 - 연결 가능
                    nx = x ; ny = y; int num =0;
                    while(true) {
                        nx += dx[d]; ny += dy[d];
                        if(nx<0 || ny<0 || nx>=N || ny>= N) {
                            dfs(cnt+1, connect +1, line+num); break;
                        }
                        map[nx][ny] = 2; num++;
                    }
                    while(true) {
                        nx -= dx[d]; ny -= dy[d];
                        if(map[nx][ny] == 1) break;
                        map[nx][ny] = 0;
                    }
                    continue f;
                }
                else if(map[nx][ny] == 1 || map[nx][ny] == 2) continue f;
            }
        }
        dfs(cnt+1, connect, line);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            count = 0;
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        if(i != 0 && j != 0 && i != N-1 && j != N-1) count++;
                    }
                }
            }
            // 입력 받음
            core = new int[count][2];
            int cnt = 0; int temp =0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] == 1) {
                        if(i != 0 && j != 0 && i != N-1 && j != N-1) core[cnt++] = new int[] {i, j};
                    }
                }
            }
						max_line = Integer.MAX_VALUE; max_power = 0;
            dfs(0, 0, 0);
            sb.append("#").append(t).append(" ").append(max_line).append("\\n");
        }
        System.out.println(sb);
    }
}
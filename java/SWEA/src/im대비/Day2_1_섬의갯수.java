package im대비;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_1_섬의갯수 {
    static int[][] map;
    static int[][] visit;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int h;
    static int w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) { // 0 0 들어오면 종료 
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 1 = 땅 , 0 = 바다
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            map = new int[h][w];
            visit = new int[h][w];
            int ans = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visit[i][j] != 1 && map[i][j] == 1) { 
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }

    }

    static void dfs(int x, int y) {
        visit[x][y] = 1;
        for (int i = 0; i < 8; i++) {
            int idx = x + dx[i];
            int idy = y + dy[i];

            if (idx < 0 || idy < 0 || idx >= h || idy >= w) continue; //경계설정 
            if (map[idx][idy] == 1 && visit[idx][idy] != 1) //맵이 섬이면서 방문하지않았으면 dfs
                dfs(idx, idy);
        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1_21_17142_연구소2 {
    private static int n;
    private static int m;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int minSec;
    private static List<VirusLocation> list;
    private static int empty;

    static class VirusLocation {
        int x, y;

        public VirusLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        list = new LinkedList<>();
        empty = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    list.add(new VirusLocation(i, j));
                } else if (arr[i][j] == 0) {
                    empty++;
                }
            }
        }

        minSec = Integer.MAX_VALUE;
        boolean[] visited = new boolean[list.size()];
        selectActive(0, 0, visited, arr);

        System.out.println(minSec == Integer.MAX_VALUE ? -1 : minSec);
    }

    private static void selectActive(int start, int activeCnt, boolean[] visited, int[][] arr) {
        if (activeCnt == m) {
            spreadVirus(visited, arr);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectActive(start, activeCnt + 1, visited, arr);
                visited[i] = false;
            }
        }
    }

    private static void spreadVirus(boolean[] visited, int[][] arr) {
        int[][] tempArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, tempArr[i], 0, n);
        }

        Queue<VirusLocation> q = new LinkedList<>();
        boolean[][] infected = new boolean[n][n];
        int spreadCount = 0;

        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) {
                VirusLocation now = list.get(i);
                q.add(now);
                infected[now.x][now.y] = true;
            }
        }

        int time = 0;

        while (!q.isEmpty() && spreadCount < empty) {
            int size = q.size();
            boolean spread = false; // 바이러스가 퍼졌는지 체크
            for (int i = 0; i < size; i++) {
                VirusLocation now = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n && !infected[nx][ny]) {
                        if (tempArr[nx][ny] == 0) {
                            spreadCount++;
                            spread = true;
                        }
                        if (tempArr[nx][ny] != 1) {
                            infected[nx][ny] = true;
                            q.add(new VirusLocation(nx, ny));
                        }
                    }
                }
            }
            if (spread) {
                time++;
            }
        }

        if (spreadCount == empty) {
            minSec = Math.min(minSec, time);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1_21_17142_연구소 {
    private static int n;
    private static int m;
    private static int[] dx = { 1, -1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };
    private static int minSec;
    private static List<virusLocation> list;
    private static int empty;

    static class virusLocation {
        int x;
        int y;

        public virusLocation(int x, int y) {
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
                    list.add(new virusLocation(i, j));
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

        for (int i = start; i < list.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectActive(i + 1, activeCnt + 1, visited, arr);
                visited[i] = false;
            }
        }
    }

    private static void spreadVirus(boolean[] visited, int[][] arr) {
        int cnt = 0; // 바이러스 퍼진 빈 공간 수
        int sec = 0;
        Queue<virusLocation> q = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) {
                q.add(list.get(i));
            }
        }
        q.add(null); // 사이클 구분을 위한 null 삽입
        boolean[][] arrVisited = new boolean[n][n];

        while (!q.isEmpty()) {
            virusLocation now = q.poll();

            if (now == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                }
                sec++;
            } else {
                for (int k = 0; k < 4; k++) {
                    int idx = now.x + dx[k];
                    int idy = now.y + dy[k];
                    if (0 <= idx && idx < n && 0 <= idy && idy < n && !arrVisited[idx][idy]) {
                        if (arr[idx][idy] == 0) {
                            arrVisited[idx][idy] = true;
                            cnt++;
                            q.add(new virusLocation(idx, idy));
                        } else if (arr[idx][idy] == 2) {
                            q.add(new virusLocation(idx, idy));
                        }
                    }
                }
            }
        }

        if (cnt == empty) {
            minSec = Math.min(minSec, sec);
        }
    }
}

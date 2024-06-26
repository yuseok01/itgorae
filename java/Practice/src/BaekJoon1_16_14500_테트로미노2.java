import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_16_14500_테트로미노2 {
    private static int n;
    private static int m;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                solution(i, j, arr[i][j], 1);
                visited[i][j] = false;
                checkExtraShapes(i, j);
            }
        }

        System.out.println(maxSum);
    }

    private static void solution(int x, int y, int sum, int depth) {
        if (depth == 4) {
            maxSum = Math.max(sum, maxSum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                solution(nx, ny, sum + arr[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    private static void checkExtraShapes(int x, int y) {
        // "ㅗ", "ㅜ", "ㅏ", "ㅓ" 모양을 확인
        if (x >= 0 && x < n - 1 && y >= 1 && y < m - 1) {
            int sum = arr[x][y] + arr[x][y - 1] + arr[x][y + 1] + arr[x + 1][y];
            maxSum = Math.max(maxSum, sum);
        }
        if (x >= 1 && x < n && y >= 1 && y < m - 1) {
            int sum = arr[x][y] + arr[x][y - 1] + arr[x][y + 1] + arr[x - 1][y];
            maxSum = Math.max(maxSum, sum);
        }
        if (x >= 1 && x < n - 1 && y >= 0 && y < m - 1) {
            int sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1];
            maxSum = Math.max(maxSum, sum);
        }
        if (x >= 1 && x < n - 1 && y >= 1 && y < m) {
            int sum = arr[x][y] + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1];
            maxSum = Math.max(maxSum, sum);
        }
    }
}

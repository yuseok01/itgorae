import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_14_14500_테트로미노 {
    static int[][] dx = {
        {0, 0, 0, 0}, {0, 1, 2, 3}, {0, 0, 0, 0}, {0, -1, -2, -3}, // ----의 x 
        {0, 1, 2, 2}, {0, 0, 0, 1}, {0, -1, -2, -2}, {0, 0, 0, -1}, // ㄴ자의 x
        {0, 1, 1, 2}, {0, 0, 1, 1}, {0, -1, -1, -2}, {0, 0, -1, -1}, // Z 모양의 x
        {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, -2, -1}, // ㅗ 모양의 x
        {0, 0, 1, 1} // 정사각형의 x
    };

    static int[][] dy = {
        {0, 1, 2, 3}, {0, 0, 0, 0}, {0, -1, -2, -3}, {0, 0, 0, 0}, // ----의 y 
        {0, 0, 0, 1}, {0, -1, -2, -2}, {0, 0, 0, -1}, {0, -1, -2, -2}, // ㄴ자의 y
        {0, 0, 1, 1}, {0, -1, -1, -2}, {0, 0, -1, -1}, {0, 1, 1, 2}, // Z 모양의 y
        {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, -2, -1}, {0, 0, 0, 1}, // ㅗ 모양의 y
        {0, 1, 0, 1} // 정사각형의 y
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 모든 도형에 대해 확인
                for (int num = 0; num < dx.length; num++) {
                    int sum = 0;
                    boolean isValid = true;
                    for (int dir = 0; dir < 4; dir++) {
                        int nowX = i + dx[num][dir];
                        int nowY = j + dy[num][dir];
                        if (0 <= nowX && nowX < n && 0 <= nowY && nowY < m) {
                            sum += arr[nowX][nowY];
                        } else {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}

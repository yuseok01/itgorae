import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Softeer_1_로봇이지나간경로 {

    private static int x;
    private static int y;
    private static int goal;
    private static int resultCnt = Integer.MAX_VALUE;
    private static int resultX;
    private static int resultY;
    private static char[][] map;
    private static boolean[][] visited;
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up
    private static final String[] directionNames = {"R", "D", "L", "U"};
    private static String resultPath = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        goal = 0;
        map = new char[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            String input = br.readLine();
            for (int j = 0; j < y; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '#') {
                    goal++;
                }
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == '#') {
                    visited[i][j] = true;
                    findResult(i, j, 1, goal, 0, 0, new StringBuilder("(" + i + "," + j + ")"));
                    visited[i][j] = false;
                }
            }
        }

        System.out.println(resultX + " " + resultY);
        System.out.println(resultPath);
    }

    private static void findResult(int startX, int startY, int depth, int goal, int cnt, int direction, StringBuilder path) {
        if (depth == goal) {
            if (resultCnt > cnt) {
                resultCnt = cnt;
                resultX = startX;
                resultY = startY;
                resultPath = path.toString();
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            if (direction == dir) {
                continue; // Skip the same direction
            }
            int newDirection = dir;
            String turnCommand = (direction - dir == 1 || direction - dir == -3) ? "L" : "R";
            StringBuilder newPath = new StringBuilder(path);
            newPath.append(" -> ").append(turnCommand);

            int newX = startX + directions[newDirection][0] * 2;
            int newY = startY + directions[newDirection][1] * 2;

            if (isInBounds(newX, newY) && map[newX][newY] == '#' && map[startX + directions[newDirection][0]][startY + directions[newDirection][1]] == '#') {
                visited[newX][newY] = true;
                newPath.append(" -> A(").append(newX).append(",").append(newY).append(")");
                findResult(newX, newY, depth + 1, goal, cnt + 1, newDirection, newPath);
                visited[newX][newY] = false;
            }
        }
    }

    private static boolean isInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < Softeer_1_로봇이지나간경로.x && y < Softeer_1_로봇이지나간경로.y;
    }
}

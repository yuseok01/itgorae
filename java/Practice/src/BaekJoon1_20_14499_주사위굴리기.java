import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1_20_14499_주사위굴리기 {
    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        int[][] map = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Location> queue = new ArrayDeque<>();
        queue.add(new Location(startX, startY));

        int[] dice = new int[7]; // index 1부터 사용하기 위해 크기 7로 설정 (0은 사용하지 않음)
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            if (!st.hasMoreTokens()) {
                break; // 입력이 부족한 경우 종료
            }
            int command = Integer.parseInt(st.nextToken());

            Location current = queue.poll();
            if (current == null) {	
                continue; // 큐가 비어있는 경우 다음 명령으로
            }
            int nx = current.x;
            int ny = current.y;

            switch (command) {
                case 1: // 동쪽
                    ny++;
                    if (ny >= y) { // 경계를 넘어가면 다음 명령으로
                        ny--;
                        queue.add(new Location(nx, ny));
                        continue;
                    }
                    break;
                case 2: // 서쪽
                    ny--;
                    if (ny < 0) { // 경계를 넘어가면 다음 명령으로
                        ny++;
                        queue.add(new Location(nx, ny));
                        continue;
                    }
                    break;
                case 3: // 북쪽
                    nx--;
                    if (nx < 0) { // 경계를 넘어가면 다음 명령으로
                        nx++;
                        queue.add(new Location(nx, ny));
                        continue;
                    }
                    break;
                case 4: // 남쪽
                    nx++;
                    if (nx >= x) { // 경계를 넘어가면 다음 명령으로
                        nx--;
                        queue.add(new Location(nx, ny));
                        continue;
                    }
                    break;
            }

            queue.add(new Location(nx, ny)); // 현재 주사위 위치 갱신

            // 주사위 굴리기
            rollDice(command, dice);

            // 지도의 숫자에 따라 주사위의 밑면 값 설정 및 출력
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }
            System.out.println(dice[1]);
        }
    }

    // 주사위를 굴리는 메소드
    private static void rollDice(int command, int[] dice) {
        int[] temp = dice.clone();

        switch (command) { // 1이 천장 6이 바닥
            case 1: // 동쪽
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[4] = temp[6];
                dice[6] = temp[3];
                break;
            case 2: // 서쪽
                dice[1] = temp[3];
                dice[3] = temp[6];
                dice[4] = temp[1];
                dice[6] = temp[4];
                break;
            case 3: // 북쪽
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[5] = temp[6];
                dice[6] = temp[2];
                break;
            case 4: // 남쪽
                dice[1] = temp[2];
                dice[2] = temp[6];
                dice[5] = temp[1];
                dice[6] = temp[5];
                break;
        }
    }
}

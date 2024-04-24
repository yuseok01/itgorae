package Day_4;

import java.util.Scanner;

public class Algo2_서울_5반_이보경 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력받기 위한 스캐너 인스턴스 생성
        int T = sc.nextInt(); // 테스트케이스의 갯수 T

        // T만큼 반복 (첫 tc는 1부터 시작)
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 미궁의 row 수
            int M = sc.nextInt(); // 미궁의 col 수

            int startRow = -1; // 김싸피의 시작 row값을 담을 변수
            int startCol = -1; // 김싸피의 시작 col값을 담을 변수
            int[][] map = new int[N][M]; // 미궁의 정보를 담을 2차원 배열 map

            // 미궁의 정보를 입력 받음
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    map[r][c] = sc.nextInt();

                    // -1일 경우 시작 위치 정보 갱신
                    if (map[r][c] == -1) {
                        startRow = r; // row 위치 정보 갱신
                        startCol = c; // col 위치 정보 갱신
                    }
                }
            }

            // 상하좌우 이동 시의 델타값을 담을 배열 dr, dc
            int[] dr = { -1, 1, 0, 0 }; // 상하좌우 이동 시 row값의 변화량
            int[] dc = { 0, 0, -1, 1 }; // 상하좌우 이동 시 col값의 변화량

            // int 타입의 최댓값으로 min을 초기화함
            int minEnergy = Integer.MAX_VALUE;
            
            // 상하좌우로 탈출할 때까지 이동하며 minEnergy를 구함
            outer: for (int d = 0; d < dr.length; d++) {
                int curRow = startRow; // 현재 row값을 시작할 때의 row값으로 초기화
                int curCol = startCol; // 현재 col값을 시작할 때의 col값으로 초기화
                int curEnergy = 0; // 미궁을 탈출하기 위해 소모하는 에너지의 값
                boolean hasBrokenWall = false; // 곡갱이를 사용해 벽을 부숴는지 여부

                // 탈출할 때까지 이동을 반복하기 위한 while문
                while (true) {
                    int nr = curRow + dr[d]; // 다음에 이동할 row 좌표값
                    int nc = curCol + dc[d]; // 다음에 이동할 col 좌표값

                    // 다음번 이동하는 곳이 미궁 밖이라면 while문을 종료함
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                        break;
                    }

                    // 벽을 만난 경우
                    if (map[nr][nc] == 10) {
                        // 이미 곡갱이를 사용했다면 탈출이 불가능함
                        if (hasBrokenWall) {
                            continue outer; // 다른 방향 탐색을 이어감
                        }

                        hasBrokenWall = true; // 곡갱이를 사용해서 벽을 부숨
                    }

                    curEnergy += map[nr][nc]; // 이동하는데 소모된 에너지를 더해줌
                    curRow = nr; // 현재 row값 갱신
                    curCol = nc; // 현재 col값 갱신
                } // 이동 종료

                minEnergy = Math.min(minEnergy, curEnergy); // minEnergy를 작은 값으로 갱신함

            } // 탐색 종료

            // 한 번도 탈출에 성공하지 못해서 minEnergy가 초기값 그대로라면
            if (minEnergy == Integer.MAX_VALUE) {
                minEnergy = -1; // 탈출이 불가능하다는 뜻으로 -1을 저장
            }

            System.out.printf("#%d %d\n", tc, minEnergy); // 정답 출력
        }
    }
}
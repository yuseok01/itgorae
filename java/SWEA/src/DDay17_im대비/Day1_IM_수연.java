package DDay17_im대비;
 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1_IM_수연 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // tc
        sc.nextLine(); // 개행문자 소비

        for (int test_case = 1; test_case <= T; test_case++) {
            // 게임판 생성
            int[][] game = new int[6][7];

            // 이기는 경우 저장하는 ArrayList
            List<Integer> win = new ArrayList<>();

            // 게임판 채우기
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    game[i][j] = sc.nextInt();
                }
            }

            // 탐색
            for (int i = 5; i >= 0; i--) {
                for (int j = 0; j < 7; j++) {
                    if (i >= 3) {
                        if (game[i][j] == 0) { // 빈자리 인지 체크
                            if (j >= 3 && game[i][j - 1] == 1 && game[i][j - 2] == 1 && game[i][j - 3] == 1) {
                                win.add(j);
                            } // 왼쪽으로 4개 연속
                            if (j <= 3 && game[i][j + 1] == 1 && game[i][j + 2] == 1 && game[i][j + 3] == 1) {
                                win.add(j);
                            } // 오른쪽으로 4개 연속
                            if (j <= 3 && game[i - 1][j + 1] == 1 && game[i - 2][j + 2] == 1
                                    && game[i - 3][j + 3] == 1) {
                                win.add(j);
                            } // 오른쪽위 대각 연속
                            if (j >= 3 && game[i - 1][j - 1] == 1 && game[i - 2][j - 2] == 1
                                    && game[i - 3][j - 3] == 1) {
                                win.add(j);
                            } // 왼쪽위 대각 연속
                        }
                    } else { // i<3
                        if (game[i][j] == 0) {
                            if (game[i + 1][j] == 1 && game[i + 2][j] == 1 && game[i + 3][j] == 1) {
                                win.add(j);
                            } // 아래로 4개 연속
                            if (j >= 3 && game[i][j - 1] == 1 && game[i][j - 2] == 1 && game[i][j - 3] == 1) {
                                win.add(j);
                            } // 왼쪽으로 4개 연속
                            if (j <= 3 && game[i][j + 1] == 1 && game[i][j + 2] == 1 && game[i][j + 3] == 1) {
                                win.add(j);
                            } // 오른쪽으로 4개 연속
                            if (j <= 3 && game[i + 1][j + 1] == 1 && game[i + 2][j + 2] == 1
                                    && game[i + 3][j + 3] == 1) {
                                win.add(j);
                            } // 오른쪽아래 대각 연속
                            if (j >= 3 && game[i + 1][j - 1] == 1 && game[i + 2][j - 2] == 1
                                    && game[i + 3][j - 3] == 1) {
                                win.add(j);
                            } // 왼쪽아래 대각 연속
                        }
                    }

                } // for j
            } // for i

            if (win.isEmpty()) {
                win.add(-1);
            } else {
                Collections.sort(win);
            }
            // 정답 출력
            System.out.printf("#%d %d%n", test_case, win.get(win.size() - 1));
        }
    }
}
package 월말대비;

import java.util.Scanner;
 
public class 파동파동 {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            int N = sc.nextInt(); // 배열 크기
            int M = sc.nextInt(); // 파동 시작 값
            int R = sc.nextInt() - 1; // 행
            int C = sc.nextInt() - 1; // 열
            int D = sc.nextInt(); // 증감
 
            int[][] map = new int[N][N];
 
            int[] rowSum = new int[N];
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int distance = Math.max(Math.abs(R - i), Math.abs(C - j)); // 증감의 배수는 행과 열 차이 중 최대
                    map[i][j] = M + D * distance;
                    if (map[i][j] < 0) // 음수가 되는 경우 0으로 설정
                        map[i][j] = 0;
                    else if (map[i][j] > 255) // 255가 넘어가면 255로 설정
                        map[i][j] = 255;
                }
            }
 
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    rowSum[row] += map[row][col];
                }
            }
 
            System.out.print("#" + test_case);
 
            for (int idx = 0; idx < N; idx++) {
                System.out.print(" " + rowSum[idx]);
            }
 
            System.out.println();
        }
    }
}
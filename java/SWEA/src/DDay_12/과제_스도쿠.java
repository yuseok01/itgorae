package DDay_12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * 배열입력 -> 체크 메서드 -> 행 열 사각형 중복체크 메서드 -> 체크메서드 ->결과 
 */
public class 과제_스도쿠 {  //hasSet 연습 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스의 개수

        for (int t = 1; t <= T; t++) {
            int[][] arr = new int[9][9];
            
            // 퍼즐 입력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt(); // 배열 입력 받기 
                }
            }

            boolean result = check(arr); // 배열입력 -> 체크 메서드 -> 행 열 사각형 중복체크 메서드 -> 체크메서드 ->결과 

            System.out.println("#" + t + " " + (result ? 1 : 0));
        }

        sc.close();
    }

    private static boolean check(int[][] arr) { 
        // 각 행에 대해 중복된 숫자 확인
        for (int i = 0; i < 9; i++) { //
            if (!isValidRow(arr[i])) { //행 전체를 인자로 
                return false;
            }
        }

        // 각 열에 대해 중복된 숫자 확인
        for (int j = 0; j < 9; j++) {
            if (!isValidColumn(arr, j)) { //배열과 j값을 인자로 
                return false;
            }
        }

        // 3x3 작은 격자에 대해 중복된 숫자 확인
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSquare(arr, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidRow(int[] row) {
        Set<Integer> set = new HashSet<>();
        for (int num : row) {
            if (set.contains(num)) { //중복값 검사 
                return false;
            }
            set.add(num); 
        }
        return true;
    }

    private static boolean isValidColumn(int[][] arr, int col) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (set.contains(arr[i][col])) {
                return false;
            }
            set.add(arr[i][col]);
        }
        return true;
    }

    private static boolean isValidSquare(int[][] arr, int startRow, int startCol) {
        Set<Integer> set = new HashSet<>();
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (set.contains(arr[i][j])) {
                    return false;
                }
                set.add(arr[i][j]);
            }
        }
        return true;
    }
}
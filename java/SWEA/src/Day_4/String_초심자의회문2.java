package Day_4;

import java.util.Scanner;

public class String_초심자의회문2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            String input = sc.next();

            int result = isPalindrome(input) ? 1 : 0;

            System.out.print("#" + t + " " + result);
            System.out.println();
        }
    }

    // 회문인지 여부를 판별하는 함수
    private static boolean isPalindrome(String str) {
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
package im대비;

import java.util.Scanner;

public class Day2_4_심심풀이2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 숫자의 개수 N을 입력 받음
        int N = scanner.nextInt();
        
        // 숫자 N개를 문자열로 입력 받음
        String numbers = scanner.next();
        
        // 각 자리의 숫자를 더하는 변수
        int sum = 0;
        
        // 문자열을 순회하면서 각 자리의 숫자를 더함
        for (int i = 0; i < N; i++) {
            // 문자열에서 i번째 문자를 가져와서 정수로 변환하여 더함
            sum += Character.getNumericValue(numbers.charAt(i));
        }

        // 결과 출력
        System.out.println(sum);

        // Scanner 닫기
        scanner.close();
    }
}
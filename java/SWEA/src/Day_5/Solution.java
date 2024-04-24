package Day_5;
import java.util.Scanner;
import java.util.Stack;
/*모든 시작은 (이다   (없는 )는 쓰래기이다.
 * "("
 * 만 스택에 추가 
 
 */
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            String arr = sc.next();  //입력받기 
 
            Stack<Character> stack = new Stack<>(); //스택 선언
            int pieces = 0; //피스 수 초기화
 
            for (int i = 0; i < arr.length(); i++) { //문자열 한개씩 반복
                char nowChar = arr.charAt(i); //현재 문자 초기화
                 
                if (nowChar == '(') { //현재 문자가 (라면
                    stack.push(nowChar);
                } else {
                    stack.pop();
 
                    if (arr.charAt(i - 1) == '(') {
                        pieces += stack.size();
                    } else {
                        pieces++;
                    }
                }
            }
            System.out.print("#"+t+" "+pieces);
            System.out.println();
        }
    }
}
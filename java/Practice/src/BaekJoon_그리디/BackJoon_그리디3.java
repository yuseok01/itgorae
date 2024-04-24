import java.io.*;
import java.util.*;
public class Main {
/*
 * 반대로 가는것이 시간복잡도를 줄이는 일임을 이해하자 
 * 문자열을 쉽게 뒤집고 뺄수있는 방법을 생각해보자 stringbuilder
 * deletCharAt을 활용하여 쉽게 문자열을 맨뒤에서 부터 제거할 수 있다.
 * sb.reverse()를 통해 문자열을 뒤집을 수있다.
 * sb.charAt을 통해 해당 문자열에 인덱스를 부여할 수있다. 
 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            }else if (t.charAt(t.length() - 1) == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }
        System.out.println(t.toString().equals(s.toString()) ? 1 : 0);
    }
}
package BaekJoon_Dp;
import java.util.*;

public class Baekjoon_Dp_6타일채우기 {
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      
      int map[] = new int[N + 1];

      map[0] = 1;
      for (int i = 2; i <= N; i += 2) {
         map[i] = map[i - 2] * 3;
         for (int j = i - 4; j >= 0; j -= 2) {
            map[i] += map[j] * 2;
         }
      }

      System.out.println(map[N]);
   }
}
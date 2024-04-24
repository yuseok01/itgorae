package Day7_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class 큐_준홍이의카드놀이2 {
    static int N, M;
    static int[] sum; // 합의 빈도수를 저장하는 배열
 
    static void calculateSum(Queue<Integer> left, Queue<Integer> right) {
 
        for (int i = 0; i < N; i++) {
            int l = left.poll();
            for (int j = 0; j < M; j++) {
                int r = right.poll();
 
                sum[l + r]++;
 
                right.offer(r);
            }
            left.offer(l);
        }
    }
 
    static int getMax() { // 숫자의 합의 빈도수 최대값 반환
        int max = 0;
 
        for (int i = 1; i <= N + M; i++) {
            if (sum[i] > max) {
                max = sum[i];
            }
        }
 
        return max;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
 
            sum = new int[N + M + 1]; // 1 ~ N+M까지의 결과값 개수
 
            Queue<Integer> left = new LinkedList<>(); // N개의 카드
            Queue<Integer> right = new LinkedList<>(); // M개의 카드
 
            for (int i = 1; i <= N; i++) {
                left.add(i);
            }
 
            for (int i = 1; i <= M; i++) {
                right.add(i);
            }
 
            calculateSum(left, right);
 
            int max = getMax();
 
            System.out.print("#" + tc + " ");
            for (int i = 1; i <= N + M; i++) {
                if (sum[i] == max) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
 
        } // test case
    } // main
}
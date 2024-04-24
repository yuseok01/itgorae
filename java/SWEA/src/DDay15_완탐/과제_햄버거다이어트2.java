package DDay15_완탐;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int t = 1; t<= T; t++) {
            int N = sc.nextInt();
            int L = sc.nextInt();
            int max = 0;
            int[] values = new int[N];
            int[] calories = new int[N];
            for(int i = 0; i<N;i++) {
                values[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }
             
            outer : for(int i = 0; i<(1<<N);i++) {
                int sum = 0;
                int cal = 0;
                for(int j = 0; j< N; j++) {
                    if((i & (1<<j)) > 0) {
                        cal += calories[j];
                        if(cal > L)
                            continue outer;
                        sum += values[j];
                    }
                }
                max = Math.max(max, sum);
            }
            System.out.printf("#%d %d\n",t,max);
        }
    }
     
     
     
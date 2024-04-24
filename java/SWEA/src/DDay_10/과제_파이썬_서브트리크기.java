package DDay_10;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 과제_파이썬_서브트리크기 {
    static int[] parent;
    static int[] left; 
    static int[] right;
    static int count;

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
           
            int E = sc.nextInt();
            int N = sc.nextInt();

            parent = new int[E + 2]; 
            left = new int[E + 2];
            right = new int[E + 2];

            for (int i = 0; i < E; i++) {
               
                int p = sc.nextInt();
                int c = sc.nextInt();

                if (left[p] == 0) { //인덱스 부모는 c
                    left[p] = c;
                } else {
                    right[p] = c; //왼쪽이 차있으면 부모 인덱스에 c
                }
            }

            count = 1;
            subTree(N);

            System.out.println("#" + tc + " " + count);
        }
    }

    static void subTree(int n) {
        if (left[n] != 0) { //왼쪽 부모인덱스(N)이 자식이 있으면 count++
            count++;
            subTree(left[n]); //재귀 자식으로 ㄱㄱ 
        }

        if (right[n] != 0) { //오른쪽 부모인덱스(N) 자식이 있으면 count++
            count++;
            subTree(right[n]);
        }
    }
}
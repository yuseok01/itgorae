package DDay_10;

import java.util.Scanner; 

public class 과제_파이썬_노드의합 {
	public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();
 
            int[] tree = new int[N + 2];
 
            for (int i = 0; i < M; i++) {
 
                int node = sc.nextInt();
                int value = sc.nextInt();
 
                tree[node] = value;
 
            }
 
            // 부모 노드에 자식 노드를 더해줌
            for (int i = N + 1; i > 1; i--) {
                tree[i / 2] += tree[i];
            }
 
            System.out.println("#" + test_case + " " + tree[L]);
 
        }
 
    }
 
}
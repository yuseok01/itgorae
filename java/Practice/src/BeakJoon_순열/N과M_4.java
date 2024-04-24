package BeakJoon_순열;

import java.util.Scanner;
 
public class N과M_4 {
  //비내림차순 => 중복허용 
	public static int N, M;
	public static int[] arr;
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[M];
 
		dfs(1, 0);
 
	}
 
	public static void dfs(int at, int depth) {
 
		if (depth == M) {
			for(int i = 0 ; i< M ; i++) {
				System.out.print(arr[i]+" ");
				
			}
			System.out.println();
			return;
		}
		  //비내림차순 => 중복허용  for문에 at변수 사용 
		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}
 
	}
 
}
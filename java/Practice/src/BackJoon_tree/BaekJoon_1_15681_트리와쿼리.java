package BackJoon_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_1_15681_트리와쿼리 {
	/*
	 * R을 정점으로 하는 트리를 만들자 
	 */
	private static int N;
	private static int R;
	private static int Q;
	private static ArrayList<Integer>[] List;

	private static int[] accum;
	private static boolean[] checked;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); //노드 갯수
		R = Integer.parseInt(st.nextToken()); //루트 번호
		Q = Integer.parseInt(st.nextToken()); //쿼리 갯수
		
		List = new ArrayList[N+1];
		for(int i = 1 ; i < N+1 ; i++) {
			List[i] = new ArrayList<>();
		}
		accum = new int[N+1];
		checked = new boolean[N+1];
		for(int i = 0 ; i < N-1 ; i++) {
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			List[to].add(from);
			List[from].add(to); //가중치 x 
			checked[R] = true;
		}
		dfs(R);
		
		for(int i = 0 ; i < Q ; i++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(accum[a]).append('\n');		
		}
		System.out.println(sb);
	}
	/*
	 * 1. 리프노드가 두 개 이상일때 어떻게 같은 값을 저장할 것인가.
	 * 
	 * 2. 중간에 있는 부모노드는 어떻게 값을 누적해 올것인가? 
	 * 
	 * 
	 */
	
	 static int dfs(int root) {
		 
		 int total = 1;
		 
		for(int i = 0 ; i < List[root].size(); i++) {
			int nextNode = List[root].get(i);
			
			if(!checked[nextNode]) { //갔다가 돌아오는 곳에 누적합++
				checked[nextNode] = true;
				
//				System.out.println("SystemStack에 쌓인다" +nextNode);
				
				total += dfs(nextNode); //각 층마다 total이 있다
				
//				System.out.println("SystemStack에 빠진다" +nextNode);
//				System.out.println("return 값은 " +total);
//				System.out.println("현재 노드는" + root);
			}
		}
		
//		System.out.println("현재 루트는" + root + " total은"+ total);
		return accum[root] = total;

	}
	
}

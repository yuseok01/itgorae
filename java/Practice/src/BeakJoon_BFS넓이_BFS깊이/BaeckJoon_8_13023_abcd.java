package BeakJoon_BFS넓이_BFS깊이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaeckJoon_8_13023_abcd {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n;
		int m;
		arrive = false;
		
		n= Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new ArrayList[n];
		visited = new boolean[n];
		for(int i = 0 ; i < n ;i++) {
			A[i] = new ArrayList<Integer>();
		} //어레이 사용
		for(int i = 0 ; i<m ; i++) { //친구 관계수만큼
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
		for(int i = 0 ; i< n ;i++) {
			dfs(i,1);
			if(arrive) {
				break;
			}
		}
		if(arrive) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
	private static void dfs(int now, int depth) {
		if(depth == 5 || arrive	) { //기저 조건 깊이가 5거나 완성됬거나
			arrive = true;
			return;
		}
		visited[now] = true;
		for(int i : A[now]) {
			if (!visited[i]) {
				dfs(i,depth+1);
			}
		}
		visited[now] = false;
	}

}

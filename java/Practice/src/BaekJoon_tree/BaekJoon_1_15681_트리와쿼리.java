package BaekJoon_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1_15681_트리와쿼리 {
	 static int n;
	 static int r;
	 static int q;
	 static ArrayList<Integer>[] list;
	 static int [] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //노드는 n개 간선은 n-1개 
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1]; 
		result = new int[n+1];
		Arrays.fill(result, 1); //가중치 채우기 
		
		for(int i = 0; i< list.length; i++) {
			list[i] = new ArrayList<>(); 
		}
		for(int i = 0 ; i < n-1; i++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		for(int i = 0 ; i <q ;i++) {
			dfs(r,-1);
		}
		
		
	}

	 static void dfs(int root, int k) {
		for(int a : list[root]) {
			if(k != a) {
				dfs(a,root); 
			}
		}
		if(k != -1) {
			result[k] += result[idx]
		}
	}
}

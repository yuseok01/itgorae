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
	private static ArrayList[] List;
	private static int[] w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //노드 갯수
		R = Integer.parseInt(st.nextToken()); //루트 번호
		Q = Integer.parseInt(st.nextToken()); //쿼리 갯수
		
		List = new ArrayList[N+1];
		for(int i = 1 ; i < n+1 ; i++) {
			List[i] = new ArrayList<>();
		}
		w = new int[N+1];
		for(int i = 0 ; i < N-1 ; i++) {
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			List[to].add(from);
			List[from].add(to); //가중치 x 
		}
		dfs(R, -1); 
		while(Q-- > 0) {
			int Query = Integer.parseInt(st.nextToken());			
		}	
	}

	private static void dfs(int Node, int p) {
		w[Node] = 1;
		for (int y : List[Node].get(p))
			}
		}
		
	}
	
}

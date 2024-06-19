import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1_10_20040_사이클게임2 {

	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for(int i=0; i<n; i++) { //자기자신을 부모로 
			parent[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			/*
			 * 조건 1 : X와 Y는 처음 연결하는 것
			 * 조건 2 : 부모가 다를 것
			 */
			if(find(x)==find(y)) { 
				//부모가 같다는건 같은 집단에 있다는 것 
				System.out.println(i+1);
				return;
			}else {
				union(x,y);
			}
		}
		
		System.out.println(0);
	}
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]); //경로 압축  
		//최상위 부모를 parent 배열에 초기화하여 시간 단축 
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) {//더큰 값이 상위 노드 
			parent[y] = x;
		}else {
			parent[x] = y;
		}
	}
}
